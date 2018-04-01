package nci.wherenow;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Food_Selection extends Activity implements AdapterView.OnItemSelectedListener{

    Spinner cuisineSpinner, priceSpinner, distanceSpinner, durationSpinner;
    ArrayAdapter adapter;
    Button btn;
    RecyclerView rv;
    RestaurantAdapter restaurantAdapter;

    List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_selection);

        try{

            SQLiteDatabase myDB = this.openOrCreateDatabase("Restaurants",MODE_PRIVATE,null);

            myDB.execSQL("CREATE TABLE IF NOT EXISTS restaurant (name VARCHAR(50), address VARCHAR(50), Latitude");

        }

        catch(Exception e){

            e.printStackTrace();

        }




        restaurantList = new ArrayList<>();


        //Recognising IDs from activity_main.xml for further use
        btn = findViewById(R.id.btn);
        rv = findViewById(R.id.recyclerView);


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        restaurantList.add(
                new Restaurant(
                        1,
                        "McDonalds",
                        "62 O'Connell Street Upper, North City, Dublin 1",
                        "1.3 Km",
                        "30 Minutes",
                        R.drawable.mcdonalds));

        restaurantList.add(
                new Restaurant(
                        1,
                        "SuperMacs",
                        "45/46 O'Connell Street, North City, Dublin 1 ",
                        "1.3 Km",
                        "30-60 Minutes",
                        R.drawable.supermacs));

        restaurantList.add(
                new Restaurant(
                        1,
                        "Burger King",
                        "Jervis Shopping Centre, Mary Street, North City, Dublin",
                        "1.8 Km",
                        "30-45 Minutes",
                        R.drawable.burgerking));


        restaurantAdapter = new RestaurantAdapter(this, restaurantList);
        rv.setAdapter(restaurantAdapter);

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

    //Creating Button Click to hide spinners after filter has been chosen
    public void btnClicked(View v){
        rv.setVisibility(View.VISIBLE);
        cuisineSpinner.setVisibility(View.INVISIBLE);
        priceSpinner.setVisibility(View.INVISIBLE);
        durationSpinner.setVisibility(View.INVISIBLE);
        distanceSpinner.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}