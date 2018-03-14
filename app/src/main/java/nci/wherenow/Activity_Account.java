package nci.wherenow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__account);
    }

    public void foodSelection (View view) {
        Intent startNewActivity = new Intent(this, Food_Selection.class);
        startActivity(startNewActivity);
    }

    public void mapActivity (View view) {
        Intent startNewActivity = new Intent(this, MapsActivity.class);
        startActivity(startNewActivity);
    }
}
