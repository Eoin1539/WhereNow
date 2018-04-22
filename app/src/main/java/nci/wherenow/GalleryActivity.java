package nci.wherenow;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Jamie on 20/04/2018.
 */

public class GalleryActivity extends AppCompatActivity implements OnMapReadyCallback {

    String restaurantLatitude;
    String restaurantLongitude;
    //Double latitude;
    //Double longitude;
    MapView mMapView;
    private GoogleMap googleMap;
    private GoogleMap mMap;

    LocationManager locationManager;

    LocationListener locationListener;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getIncomingIntent();

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("restaurantTitle")) {
            //Get incoming intents from Restaurant Adapter
            String restaurantTitle = getIntent().getStringExtra("restaurantTitle");
            String restaurantLatitude = getIntent().getStringExtra("restaurantLatitude");
            String restaurantLongitude = getIntent().getStringExtra("restaurantLongitude");

            //Attempting to get the double as a incoming intent.
            //Double lat = getIntent().getDoubleExtra("lat", latitude);
            //Double lon = getIntent().getDoubleExtra("lon", longitude);


            setTitle(restaurantTitle);
            setlatitude(restaurantLatitude);
            setlongitude(restaurantLongitude);

        }
    }
    //Cast the values to a textviews.

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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    {

                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                    }

                }

            }

        }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());


                mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15));


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        if (Build.VERSION.SDK_INT < 23) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        } else {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            } else {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());

                mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15));


            }


        }

        // This would be converting the double (lat & long) to be used in a function that the map marker would reference.

        //LatLng restaurant = new LatLng(latitude, longitude);
        LatLng mcd1 = new LatLng(53.3477805,-6.2610345);
        LatLng booj1 = new LatLng(53.3488712, -6.2584623);
        LatLng start = new LatLng(53.3498056, -6.2604809);
        LatLng nando = new LatLng(53.3487901, -6.268);
        LatLng seven = new LatLng(53.3485279, -6.2443073);
        LatLng drunk = new LatLng(53.3492224, -6.2448782);
        LatLng j2 = new LatLng(53.3476853, -6.2450489);
        LatLng rockets = new LatLng(53.3476569, -6.2445232);
        LatLng musashi = new LatLng(53.3491035, -6.2440619);
        LatLng toss = new LatLng(53.3487377, -6.2487459);
        LatLng bb = new LatLng(53.3494478, -6.2443449);
        LatLng milano = new LatLng(53.3482128, -6.2450042);
        LatLng east = new LatLng(53.348385, -6.244615);
        LatLng fornaio = new LatLng(53.3484815, -6.2440733);
        LatLng broadway = new LatLng(53.349994, -6.24464238);
        LatLng parigi = new LatLng(53.3463529, -6.2449788);
        LatLng mv = new LatLng(53.3475242, -6.2380027);
        LatLng star = new LatLng(53.3508567, -6.2527234);
        LatLng pantry = new LatLng(53.3504488, -6.2527793);
        LatLng thai = new LatLng(53.3511135, -6.2522776);
        LatLng supermacs = new LatLng(53.3511135, -6.2522776);
        LatLng harbour = new LatLng(53.3511135, -6.2522776);
        LatLng lebon = new LatLng(53.3507242, -6.2559258);
        LatLng zambrero = new LatLng(53.3448867, -6.2479158);
        LatLng pig = new LatLng(53.3472204, -6.2512515);
        LatLng bean = new LatLng(53.3512087, -6.2538473);
        LatLng supermacs2 = new LatLng(53.3492459, -6.2615706);
        LatLng mcd2 = new LatLng(53.3492459, -6.2615706);
        LatLng burger2 = new LatLng(53.3492459, -6.2615706);
        LatLng freshii = new LatLng(53.3502566, -6.2486585);
        LatLng chopped = new LatLng(53.3505709, -6.2532054);


        googleMap.addMarker(new MarkerOptions()
                .position(mcd1)
                .title("McDonald's O'Connell Street"));

        googleMap.addMarker(new MarkerOptions()
                .position(booj1)
                .title("Boojum Lower Abbey Street"));

        googleMap.addMarker(new MarkerOptions()
                .position(start)
                .title("Starbucks O'Connell Street"));

        googleMap.addMarker(new MarkerOptions()
                .position(nando)
                .title("Nandos - Mary Street"));

        googleMap.addMarker(new MarkerOptions()
                .position(seven)
                .title("Seven Wonders"));

        googleMap.addMarker(new MarkerOptions()
                .position(drunk)
                .title("Drunken Fish"));

        googleMap.addMarker(new MarkerOptions()
                .position(j2)
                .title("J2 Grill & Sushi"));

        googleMap.addMarker(new MarkerOptions()
                .position(rockets)
                .title("Rockets"));

        googleMap.addMarker(new MarkerOptions()
                .position(musashi)
                .title("Musashi"));

        googleMap.addMarker(new MarkerOptions()
                .position(toss)
                .title("TOSS'D Noodles & Salads"));

        googleMap.addMarker(new MarkerOptions()
                .position(bb)
                .title("Burritos & Blues"));

        googleMap.addMarker(new MarkerOptions()
                .position(milano)
                .title("Milano"));

        googleMap.addMarker(new MarkerOptions()
                .position(east)
                .title("East"));

        googleMap.addMarker(new MarkerOptions()
                .position(fornaio)
                .title("Fornaio"));

        googleMap.addMarker(new MarkerOptions()
                .position(broadway)
                .title("Broadway pizza"));

        googleMap.addMarker(new MarkerOptions()
                .position(parigi)
                .title("Caffe Parigi"));

        googleMap.addMarker(new MarkerOptions()
                .position(mv)
                .title("MV Cill Airne"));

        googleMap.addMarker(new MarkerOptions()
                .position(star)
                .title("Star Pizza"));

        googleMap.addMarker(new MarkerOptions()
                .position(pantry)
                .title("The Pantry"));

        googleMap.addMarker(new MarkerOptions()
                .position(thai)
                .title("Thai Spice"));

        googleMap.addMarker(new MarkerOptions()
                .position(supermacs)
                .title("Supermacs"));

        googleMap.addMarker(new MarkerOptions()
                .position(harbour)
                .title("The Harbourmaster"));

        googleMap.addMarker(new MarkerOptions()
                .position(lebon)
                .title("Le Bon Crubeen"));

        googleMap.addMarker(new MarkerOptions()
                .position(zambrero)
                .title("Zambrero Pearse Street"));

        googleMap.addMarker(new MarkerOptions()
                .position(pig)
                .title("The Pig & Heifer Cafe City Quay"));

        googleMap.addMarker(new MarkerOptions()
                .position(bean)
                .title("Bean & Gone Cafe"));

        googleMap.addMarker(new MarkerOptions()
                .position(supermacs2)
                .title("Supermac's"));

        googleMap.addMarker(new MarkerOptions()
                .position(mcd2)
                .title("McDonald's"));

        googleMap.addMarker(new MarkerOptions()
                .position(burger2)
                .title("Burger King"));

        googleMap.addMarker(new MarkerOptions()
                .position(freshii)
                .title("Freshii"));

        googleMap.addMarker(new MarkerOptions()
                .position(chopped)
                .title("Chopped"));




    }
}

