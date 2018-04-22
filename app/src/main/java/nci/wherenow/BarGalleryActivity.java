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
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BarGalleryActivity extends AppCompatActivity implements OnMapReadyCallback {

    String barlatitude;
    String barLongitude;
    MapView mMapView;
    private GoogleMap googleMap;
    private GoogleMap mMap;

    LocationManager locationManager;

    LocationListener locationListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_bar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getIncomingIntent();

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("barTitle")) {
            //Get incoming intents from Restaurant Adapter
            String barTitle = getIntent().getStringExtra("barTitle");
            String barLatitude = getIntent().getStringExtra("barLatitude");
            String barLongitude = getIntent().getStringExtra("barLongitude");

            //Attempting to get the double as a incoming intent.
            //Double lat = getIntent().getDoubleExtra("lat", latitude);
            //Double lon = getIntent().getDoubleExtra("lon", longitude);


            setTitle(barTitle);
            setlatitude(barLatitude);
            setlongitude(barLongitude);

        }
    }

    //Cast the values to a textviews.

    private void setTitle(String title) {
        TextView name = findViewById(R.id.barTitle);
        name.setText(title);
    }

    private void setlatitude(String latitude) {
        TextView name = findViewById(R.id.barLatitude);
        name.setText(latitude);
    }

    private void setlongitude(String longitude) {
        TextView name = findViewById(R.id.barLongitude);
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

        //Hard-coding the coordinates of the bars within the database.
        LatLng lago = new LatLng(53.3497424, -6.2438131);
        LatLng molloy = new LatLng(53.3497424, -6.2438131);
        LatLng harbour = new LatLng(53.3494549, -6.2486863);
        LatLng madigan = new LatLng(53.3513714, -6.24911);
        LatLng celt = new LatLng(53.3505549, -6.254878);
        LatLng bd = new LatLng(53.3501824, -6.2503613);
        LatLng ll = new LatLng(53.3525912, -6.249217);
        LatLng tb = new LatLng(53.3504733, - 6.25122);
        LatLng wf = new LatLng(53.3485314, -6.2553512);
        LatLng central = new LatLng(53.3479796, -6.2578941);
        LatLng cb = new LatLng(53.3492548, 6.2597914);
        LatLng bb = new LatLng(53.3480648, -6.2633044);
        LatLng tramline = new LatLng(53.3451242, -6.2604355);
        LatLng temple = new LatLng(53.3459644, -6.2624744);
        LatLng auld = new LatLng(53.3452776, -6.2633965);
        LatLng palace = new LatLng(53.3456526, -6.2621269);
        LatLng diceys = new LatLng(53.3361515, -6.2650107);
        LatLng coppers = new LatLng(53.3361515, -6.2650107);
        LatLng club = new LatLng(53.3457731, -6.2583626);
        LatLng clubm = new LatLng(53.3457731, -6.2583626);
        LatLng stag = new LatLng(53.3439939, -6.2633322);
        LatLng foggy = new LatLng(53.3442414, -6.2627644);
        LatLng buskers = new LatLng(53.3453621, -6.2630362);
        LatLng bridge = new LatLng(53.3454213, -6.2634377);
        LatLng river = new LatLng(53.346204, -6.2597043);
        LatLng ryan = new LatLng(53.3501102, -6.2519421);
        LatLng murray = new LatLng(53.3520644, -6.2607971);
        LatLng living = new LatLng(53.3525652, -6.2611377);
        LatLng oconnell = new LatLng(53.3475341, -6.2601529);
        LatLng workmans = new LatLng(53.3454449, -6.2690097);
        LatLng peadar = new LatLng(53.3451551, -6.2668893);
        LatLng merchant = new LatLng(53.3456686, -6.261746);
        LatLng vintage = new LatLng(53.3456686, -6.261746);
        LatLng mint = new LatLng(53.3459736, -6.2596171);
        LatLng yamamori = new LatLng(53.3451341, -6.2597184);
        LatLng blind = new LatLng(53.3450178, -6.2595112);
        LatLng dakota = new LatLng(53.3450178, -6.2595112);
        LatLng liquor = new LatLng(53.3450178, -6.2595112);


        googleMap.addMarker(new MarkerOptions()
                .position(lago)
                .title("Lagoona Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(molloy)
                .title("Molloy's"));

        googleMap.addMarker(new MarkerOptions()
                .position(harbour)
                .title("Harbourmaster Bar and Restaurant"));

        googleMap.addMarker(new MarkerOptions()
                .position(madigan)
                .title("Madigan's Pub Connolly Station"));

        googleMap.addMarker(new MarkerOptions()
                .position(celt)
                .title("The Celt"));

        googleMap.addMarker(new MarkerOptions()
                .position(bd)
                .title("The Brew Dock"));

        googleMap.addMarker(new MarkerOptions()
                .position(ll)
                .title("Lloyd's Bar & Lounge"));

        googleMap.addMarker(new MarkerOptions()
                .position(tb)
                .title("74 Talbot Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(wf)
                .title("The Wiley Fox"));

        googleMap.addMarker(new MarkerOptions()
                .position(central)
                .title("The Grand Central"));

        googleMap.addMarker(new MarkerOptions()
                .position(cb)
                .title("The Confession Box"));

        googleMap.addMarker(new MarkerOptions()
                .position(bb)
                .title("Bad Bobs Temple Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(tramline)
                .title("Tramline"));

        googleMap.addMarker(new MarkerOptions()
                .position(temple)
                .title("The Temple Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(auld)
                .title("The Auld Dubliner"));

        googleMap.addMarker(new MarkerOptions()
                .position(palace)
                .title("The Palace Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(diceys)
                .title("Dicey's Garden Club"));

        googleMap.addMarker(new MarkerOptions()
                .position(coppers)
                .title("Copper Face Jacks"));

        googleMap.addMarker(new MarkerOptions()
                .position(club)
                .title("Club Nassau"));

        googleMap.addMarker(new MarkerOptions()
                .position(clubm)
                .title("Club M"));

        googleMap.addMarker(new MarkerOptions()
                .position(stag)
                .title("The Stag's Head"));

        googleMap.addMarker(new MarkerOptions()
                .position(foggy)
                .title("Foggy Dew"));

        googleMap.addMarker(new MarkerOptions()
                .position(buskers)
                .title("Buskers"));

        googleMap.addMarker(new MarkerOptions()
                .position(bridge)
                .title("The Ha'penny Bridge Inn"));

        googleMap.addMarker(new MarkerOptions()
                .position(river)
                .title("River Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(ryan)
                .title("Ryan's Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(murray)
                .title("Murray's Pub"));

        googleMap.addMarker(new MarkerOptions()
                .position(living)
                .title("The Living Room"));

        googleMap.addMarker(new MarkerOptions()
                .position(oconnell)
                .title("O'Connell's Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(workmans)
                .title("The Workman's Club"));

        googleMap.addMarker(new MarkerOptions()
                .position(peadar)
                .title("Peadar Kearney's"));

        googleMap.addMarker(new MarkerOptions()
                .position(merchant)
                .title("Merchant's Arch"));

        googleMap.addMarker(new MarkerOptions()
                .position(vintage)
                .title("Vintage Cocktail Club"));

        googleMap.addMarker(new MarkerOptions()
                .position(mint)
                .title("The Mint Bar"));

        googleMap.addMarker(new MarkerOptions()
                .position(yamamori)
                .title("Yamamori Tengu"));

        googleMap.addMarker(new MarkerOptions()
                .position(blind)
                .title("The Blind Pig Speakeasy"));

        googleMap.addMarker(new MarkerOptions()
                .position(dakota)
                .title("Dakota"));

        googleMap.addMarker(new MarkerOptions()
                .position(liquor)
                .title("The Liquor Rooms"));





        }

    }

