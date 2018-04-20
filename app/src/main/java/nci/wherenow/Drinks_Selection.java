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

public class Drinks_Selection extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner cuisineSpinner, priceSpinner, distanceSpinner, durationSpinner;
    ArrayAdapter adapter;
    Button btn;

    List<Bar> barList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks_selection);

        barList = new ArrayList<>();


        //Recognising IDs from activity_main.xml for further use
        btn = findViewById(R.id.btn);

        //Importing Cuisines into the Cuisine Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.cuisine, android.R.layout.simple_spinner_dropdown_item);

        cuisineSpinner = findViewById(R.id.cuisineSpinner);
        cuisineSpinner.setAdapter(adapter);
        cuisineSpinner.setOnItemSelectedListener(Drinks_Selection.this);

        //Importing Prices into the Price Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.price, android.R.layout.simple_spinner_dropdown_item);

        priceSpinner = findViewById(R.id.priceSpinner);
        priceSpinner.setAdapter(adapter);
        priceSpinner.setOnItemSelectedListener(Drinks_Selection.this);

        //Importing Duration into the Duration Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.duration, android.R.layout.simple_spinner_dropdown_item);

        durationSpinner = findViewById(R.id.durationSpinner);
        durationSpinner.setAdapter(adapter);
        durationSpinner.setOnItemSelectedListener(Drinks_Selection.this);

        //Importing Distance into the Distance Spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.distance, android.R.layout.simple_spinner_dropdown_item);

        distanceSpinner = findViewById(R.id.distanceSpinner);
        distanceSpinner.setAdapter(adapter);
        distanceSpinner.setOnItemSelectedListener(Drinks_Selection.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void btnClicked (View v){
        Intent startNewActivity = new Intent (this, Bar_Results.class);
        startActivity(startNewActivity);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}