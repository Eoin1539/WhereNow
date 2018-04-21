package nci.wherenow;


import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Bar_Results extends AppCompatActivity {

    RecyclerView rv;
    BarAdapter barAdapter;
    List<Bar> barList;
    FirebaseDatabase FDB;
    DatabaseReference DBR;

    String barStyle;
    String priceRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_results);


        barStyle = getIntent().getStringExtra("barStyle");
        priceRange = getIntent().getStringExtra("priceRange");

        //Recognising IDs from activity_main.xml for further use
        rv = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager LM = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(LM);
        rv.setHasFixedSize(true);


        barList = new ArrayList<>();
        barAdapter = new BarAdapter(barList);

        FDB = FirebaseDatabase.getInstance();
        GetDataFirebase();
    }

    void GetDataFirebase(){

        DBR = FDB.getReference("barRecycler");
        DBR.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dS, String s) {
                Bar bar = dS.getValue(Bar.class);
                if(barStyle.equals(bar.getBarStyle())){

                    if(priceRange.equals(bar.getPriceRange())) {
                        barList.add(bar);
                    }
                }

                rv.setAdapter(barAdapter);
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