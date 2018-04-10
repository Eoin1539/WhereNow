package nci.wherenow;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Restaurant_Results extends AppCompatActivity {

    RecyclerView rv;
    RestaurantAdapter restaurantAdapter;
    List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_results);

        restaurantList = new ArrayList<>();


        //Recognising IDs from activity_main.xml for further use
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

    }
}