package nci.wherenow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Jamie on 20/04/2018.
 */

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getIncomingIntent();

    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("restaurantTitle")){

            String restaurantTitle = getIntent().getStringExtra("restaurantTitle");
            String restaurantLatitude = getIntent().getStringExtra("restaurantLatitude");
            String restaurantLongitude = getIntent().getStringExtra("restaurantLongitude");

            setTitle(restaurantTitle);
            setlatitude(restaurantLatitude);
            setlongitude(restaurantLongitude);

        }
    }

    private void setTitle(String title){
        TextView name = findViewById(R.id.restaurantTitle);
        name.setText(title);
    }

    private void setlatitude(String latitude){
        TextView name = findViewById(R.id.restaurantLatitude);
        name.setText(latitude);
    }

    private void setlongitude(String longitude){
        TextView name = findViewById(R.id.restaurantLongitude);
        name.setText(longitude);
    }
}
