package com.cokrodev.googlemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private Button normal, satelit, terain, hybrid, none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        normal  = (Button)findViewById(R.id.normal);
        satelit = (Button)findViewById(R.id.satelit);
        hybrid  = (Button)findViewById(R.id.hybrid);
        terain  = (Button)findViewById(R.id.terrain);
        none    = (Button)findViewById(R.id.none);

        normal.setOnClickListener(this);
        satelit.setOnClickListener(this);
        hybrid.setOnClickListener(this);
        terain.setOnClickListener(this);
        none.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onClick(View v){
        // TODO Auto-generated method stub
        switch (v.getId()){
            case R.id.normal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                Toast.makeText(getApplicationContext(),"Kustomisasi Type Normal Dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.satelit:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                Toast.makeText(getApplicationContext(),"Kustomisasi Type Satelit Dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                Toast.makeText(getApplicationContext(),"Kustomisasi Type Hybrid Dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.terrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                Toast.makeText(getApplicationContext(),"Kustomisasi Type Terrain Dipilih", Toast.LENGTH_SHORT).show();
                break;
            case R.id.none:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                Toast.makeText(getApplicationContext(),"Kustomisasi Type None Dipilih", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
}
