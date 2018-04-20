package nci.wherenow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class Food_Selection extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner cuisineSpinner, priceSpinner, distanceSpinner, durationSpinner;
    ArrayAdapter adapter;
    Button btn;

    List<Restaurant> restaurantList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_selection);

        restaurantList = new ArrayList<>();


        //Recognising IDs from activity_main.xml for further use
        btn = findViewById(R.id.btn);

        //Importing Cuisines into the Cuisine Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.cuisine, android.R.layout.simple_spinner_dropdown_item);

        cuisineSpinner = findViewById(R.id.cuisineSpinner);
        cuisineSpinner.setAdapter(adapter);
        cuisineSpinner.setOnItemSelectedListener(Food_Selection.this);

        //Importing Prices into the Price Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.price, android.R.layout.simple_spinner_dropdown_item);

        priceSpinner = findViewById(R.id.priceSpinner);
        priceSpinner.setAdapter(adapter);
        priceSpinner.setOnItemSelectedListener(Food_Selection.this);

        //Importing Duration into the Duration Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.duration, android.R.layout.simple_spinner_dropdown_item);

        durationSpinner = findViewById(R.id.durationSpinner);
        durationSpinner.setAdapter(adapter);
        durationSpinner.setOnItemSelectedListener(Food_Selection.this);

        //Importing Distance into the Distance Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.distance, android.R.layout.simple_spinner_dropdown_item);

        distanceSpinner = findViewById(R.id.distanceSpinner);
        distanceSpinner.setAdapter(adapter);
        distanceSpinner.setOnItemSelectedListener(Food_Selection.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }


    //Creating Button Click to start new activity after filter has been chosen

    public void btnClicked (View v){
        String cuisine = cuisineSpinner.getSelectedItem().toString();
        Intent i = new Intent (this, Restaurant_Results.class);
        i.putExtra("cuisine", cuisine);


        startActivity(i);


    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}