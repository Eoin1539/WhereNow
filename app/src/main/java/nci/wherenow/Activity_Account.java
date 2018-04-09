package nci.wherenow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Activity_Account extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private Button mLogoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__account);

        mLogoutBtn = (Button) findViewById(R.id.logoutBtn);

        mAuth=FirebaseAuth.getInstance();

        mLogoutBtn.setOnClickListener(new View.OnClickListener()

        {

            public void onClick (View view){

            }

        });

















    }

    public void foodSelection(View view) {
        Intent startNewActivity = new Intent(this, Food_Selection.class);
        startActivity(startNewActivity);
    }

    public void mapActivity(View view) {
        Intent startNewActivity = new Intent(this, MapsActivity.class);
        startActivity(startNewActivity);
    }




}





