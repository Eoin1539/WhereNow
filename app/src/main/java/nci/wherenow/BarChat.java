package nci.wherenow;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import static nci.wherenow.R.layout.activity_bar_chat;

public class BarChat extends AppCompatActivity {
    FloatingActionButton send;
    EditText input;
    ListView messages;
    private String loggedInUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_bar_chat);
        send = (FloatingActionButton)findViewById(R.id.send);
        input = (EditText)findViewById(R.id.input);
        messages = (ListView)findViewById(R.id.messages);
        showOldMessages();

            send.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (input.getText().toString().trim().equals("")) {
                Toast.makeText(BarChat.this, "Enter message.", Toast.LENGTH_SHORT).show();
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


    public void showOldMessages() {
        loggedInUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseListAdapter adapter = new messageAdapter(this, message.class, R.layout.messagein,
                FirebaseDatabase.getInstance().getReference());
        messages.setAdapter(adapter);
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

}





