package nci.wherenow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

                mAuth.signOut();

                LoginManager.getInstance().logOut();

                updateUI();

            }

        });



    }

    @Override
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null){
            updateUI();
        }
    }

    private void updateUI(){
        Toast.makeText(Activity_Account.this,"You are logged out", Toast.LENGTH_LONG).show();

        Intent accountIntent = new Intent(Activity_Account.this, MainActivity.class);
        startActivity(accountIntent);
        finish();
    }
    
    public void drinkbtn(View view) {
        Intent startNewActivity = new Intent(this, Drinks_Selection.class);
        startActivity(startNewActivity);
    }
    
    public void foodbtn(View view) {
        Intent startNewActivity = new Intent(this, Food_Selection.class);
        startActivity(startNewActivity);
    }

    public void mapbtn(View view) {
        Intent startNewActivity = new Intent(this, MapsActivity.class);
        startActivity(startNewActivity);
    }

    public void socialbtn(View view) {
        Intent startNewActivity = new Intent(this, RestaurantChat.class);
        startActivity(startNewActivity);
    }
    }








