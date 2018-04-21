package nci.wherenow;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Jamie on 20/04/2018.
 */

public class GalleryActivity extends AppCompatActivity implements OnMapReadyCallback {

    String restaurantLatitude;
    String restaurantLongitude;
    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getIncomingIntent();

        //converting string to double for lat and long
        //double storeLat = Double.parseDouble("restaurantLatitude");
        //double storeLon = Double.parseDouble("restaurantLongitude");

        /*// Using latitude and longitude function for creating a position for store
        LatLng position = new LatLng(storeLat, storeLon);*/

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("restaurantTitle")) {

            String restaurantTitle = getIntent().getStringExtra("restaurantTitle");
            String restaurantLatitude = getIntent().getStringExtra("restaurantLatitude");
            String restaurantLongitude = getIntent().getStringExtra("restaurantLongitude");


            setTitle(restaurantTitle);
            setlatitude(restaurantLatitude);
            setlongitude(restaurantLongitude);

        }
    }

    private void setTitle(String title) {
        TextView name = findViewById(R.id.restaurantTitle);
        name.setText(title);
    }

    private void setlatitude(String latitude) {
        TextView name = findViewById(R.id.restaurantLatitude);
        name.setText(latitude);
    }

    private void setlongitude(String longitude) {
        TextView name = findViewById(R.id.restaurantLongitude);
        name.setText(longitude);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }
}

