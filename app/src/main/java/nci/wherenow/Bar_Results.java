package nci.wherenow;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Bar_Results extends AppCompatActivity {

    RecyclerView rv;
    BarAdapter barAdapter;
    List<Bar> barList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_results);

        barList = new ArrayList<>();


        //Recognising IDs from activity_main.xml for further use
        rv = findViewById(R.id.recyclerView);


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        barList.add(
                new Bar(
                        1,
                        "McDonalds",
                        "62 O'Connell Street Upper, North City, Dublin 1",
                        "1.3 Km",
                        "30 Minutes",
                        R.drawable.mcdonalds));

        barList.add(
                new Bar(
                        2,
                        "SuperMacs",
                        "45/46 O'Connell Street, North City, Dublin 1 ",
                        "1.3 Km",
                        "30-60 Minutes",
                        R.drawable.supermacs));

        barList.add(
                new Bar(
                        3,
                        "Burger King",
                        "Jervis Shopping Centre, Mary Street, North City, Dublin",
                        "1.8 Km",
                        "30-45 Minutes",
                        R.drawable.burgerking));
        barList.add(
                new Bar(
                        4,
                        "McDonalds",
                        "62 O'Connell Street Upper, North City, Dublin 1",
                        "1.3 Km",
                        "30 Minutes",
                        R.drawable.mcdonalds));

        barList.add(
                new Bar(
                        5,
                        "SuperMacs",
                        "45/46 O'Connell Street, North City, Dublin 1 ",
                        "1.3 Km",
                        "30-60 Minutes",
                        R.drawable.supermacs));

        barList.add(
                new Bar(
                        6,
                        "Burger King",
                        "Jervis Shopping Centre, Mary Street, North City, Dublin",
                        "1.8 Km",
                        "30-45 Minutes",
                        R.drawable.burgerking));



        barAdapter = new BarAdapter(this, barList);
        rv.setAdapter(barAdapter);

    }
}