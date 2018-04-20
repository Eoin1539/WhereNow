package nci.wherenow;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Restaurant_Results extends AppCompatActivity {

    RecyclerView rv;
    RestaurantAdapter restaurantAdapter;
    List<Restaurant> restaurantList;
    FirebaseDatabase FDB;
    DatabaseReference DBR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_results);


        //Recognising IDs from activity_main.xml for further use
        rv = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager LM = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(LM);
        rv.setHasFixedSize(true);

        restaurantList = new ArrayList<>();
        restaurantAdapter = new RestaurantAdapter(restaurantList);


        FDB = FirebaseDatabase.getInstance();
        GetDataFirebase();
    }

    void GetDataFirebase(){

        DBR = FDB.getReference("recyclerview");
        DBR.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dS, String s) {
                Restaurant restaurant = new Restaurant();
                restaurant = dS.getValue(Restaurant.class);

                restaurantList.add(restaurant);

                rv.setAdapter(restaurantAdapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}