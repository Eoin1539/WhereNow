package nci.wherenow;

import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View.OnClickListener;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.*;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;

import static nci.wherenow.R.layout.*;

public class RestaurantChat extends AppCompatActivity {
    FloatingActionButton send;
    EditText input;
    ListView messages;
    private String loggedInUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_restaurant_chat);
        send = (FloatingActionButton)findViewById(R.id.send);
        input = (EditText)findViewById(R.id.input);
        messages = (ListView)findViewById(R.id.messages);
        showAllOldMessages();

            send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (input.getText().toString().trim().equals("")) {
                Toast.makeText(RestaurantChat.this, "Please enter some texts!", Toast.LENGTH_SHORT).show();
            } else {
                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new message(input.getText().toString(),
                                FirebaseAuth.getInstance().getCurrentUser().getDisplayName(),
                                FirebaseAuth.getInstance().getCurrentUser().getUid())
                        );
                input.setText("");
            }
        }
    });
    }

    public void showAllOldMessages() {
        try {
            loggedInUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
            FirebaseListAdapter adapter = new messageAdapter(this, message.class, R.layout.messagein,
                    FirebaseDatabase.getInstance().getReference());
            messages.setAdapter(adapter);
        }
        catch(DatabaseException ex){
            ex.printStackTrace();
        }
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

}





