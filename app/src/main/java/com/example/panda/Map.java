package com.example.panda;


import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class Map extends Fragment implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, ActivityCompat.OnRequestPermissionsResultCallback ,
        GoogleMap.OnMapLongClickListener, GoogleMap.OnMapClickListener, GoogleMap.OnCameraIdleListener,
        GoogleMap.OnPoiClickListener, GoogleMap.OnInfoWindowClickListener {


    public static Map newmap() {
        Map fragment = new Map();
        return fragment;
    }


    private MapView mapView;
    private View v;
    private TextView locationSearch;
    private Button btnSearch;
    private GoogleMap map;
    Marker marker;


    private static final int LOCATION_REQUEST_CODE = 1;
    private boolean mLocationPermissionGranted ;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.maps, container, false);

        locationSearch =  v.findViewById(R.id.editText);
        btnSearch = v.findViewById(R.id.btnsearch);

        mapView = v.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchLocation();
            }
        });


        return v;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        map.setOnMyLocationClickListener(this);
        map.setOnMyLocationButtonClickListener(this);
        getLocationPermission();
//        map.setOnMapClickListener(this);
//        map.setOnMapLongClickListener(this);
//        map.setOnCameraIdleListener(this);
        map.setOnPoiClickListener(this);
        map.clear();
//        map.setOnInfoWindowClickListener(this);




    }
    private void getLocationPermission() {

        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        }else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, LOCATION_REQUEST_CODE);
        }

        // chance button click my location
        View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
        // position on right bottom
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);rlp.setMargins(0,0,30,30);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode != LOCATION_REQUEST_CODE) {
            return;
        }

        if (permissions.length == 1 &&
                permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getLocationPermission();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mLocationPermissionGranted = true;
        }

    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(getActivity(), "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        String StreetName = null;
        String StreetAddress = null;
        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
        List<Address> addresses = null;

        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {


            if (addresses.size() > 0)
//
//                StreetName =   addresses.get(0).getFeatureName() + "\t" //ten diachi_ uoc chug ko cxac
//                       +addresses.get(0).getThoroughfare()+ "\t"  // ten duong
//                       + addresses.get(0).getAdminArea() + "\t"        //ten thanh pho
//                       + addresses.get(0).getCountryName()+ "\t"  ;      //ten quoc gia

                StreetAddress = addresses.get(0).getAddressLine(0);


            String s = "Kinh Độ:\t"+ location.getLongitude()  +"\t\t" + "Vĩ Độ:\t"+ location.getLatitude() +"\n"+ StreetAddress ;
            Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }

//        Toast.makeText(getActivity(), "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapLongClick(LatLng point) {
 //       mTapTextView.setText("long pressed, point= " + point);

    }

    @Override
    public void onCameraIdle() {
  //      mCameraTextView.setText(map.getCameraPosition().toString());


    }

    @Override
    public void onMapClick(LatLng point) {
 //       mTapTextView.setText("tapped, point= " + point);

    }
    @Override
    public void onPoiClick(PointOfInterest poi) {

//        String StreetAddress = null;
//        Location location = new Location(poi.name);
//        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
//        List<Address> addresses = null;
//
//        try {
//            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 100);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (addresses.size() > 0)
//                StreetAddress = addresses.get(1).getAddressLine(1);
//
//        }catch (Exception e){
//
//        }


        Toast.makeText(getActivity(),
                "" + poi.name +
                        "\nPlace ID:" + poi.placeId +
                        "\nLatitude:" + poi.latLng.latitude +
                        "\nLongitude:" + poi.latLng.longitude,
                Toast.LENGTH_SHORT).show();

        if ( marker != null){
            marker.remove();
        }

        LatLng latLng = new LatLng(poi.latLng.latitude, poi.latLng.longitude);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title(poi.name);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        marker = map.addMarker(markerOptions);
    }

    public void searchLocation() {
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(getActivity());
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                map.addMarker(new MarkerOptions().position(latLng).title(location));
                map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                Toast.makeText(getActivity(),address.getLatitude()+" "+address.getLongitude(),Toast.LENGTH_LONG).show();
            }catch (Exception e){}

        }
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(getActivity(), "Info window clicked",
                Toast.LENGTH_SHORT).show();
    }
}

