package com.example.dtzdrav;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
//import android.support.design.widget.BottomSheetDialog;
//import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import org.json.JSONException;
import org.json.JSONObject;

import static android.graphics.Color.TRANSPARENT;

public class MapsActivity extends Fragment implements OnMapReadyCallback {
    public static MapsActivity newInstance() {
        MapsActivity fragment = new MapsActivity();
        return fragment;
    }
    public static GoogleMap mMap;
    public fetchData data;
    TextView textName;
    TextView textText;
    TextView textUsver;
    TextView textPhone;
    Dialog d;
    //MainActivity mainActivity;

    //public MapsActivity(MainActivity mainActivity){
    //    this.mainActivity = mainActivity;
    //}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                //.findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
        //data = new fetchData();
        //data.execute();
        //d = new BottomSheetDialog(this);
        //d.setContentView(R.layout.dailog);
        //textName = (TextView) d.findViewById(R.id.textName);
        //textText = (TextView) d.findViewById(R.id.textText);
        //textUsver = (TextView) d.findViewById(R.id.textUsver);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_maps, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        data = new fetchData();
        data.execute();
        d = new Dialog(view.getContext());
        d.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        // Передайте ссылку на разметку
        d.setContentView(R.layout.card);
        d.setCanceledOnTouchOutside(true);
        //d.show();
        textName = (TextView) d.findViewById(R.id.textView2);
        textText = (TextView) d.findViewById(R.id.textView3);
        textUsver = (TextView) d.findViewById(R.id.textView5);
        textPhone = (TextView) d.findViewById(R.id.textView6);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setCameraPosition(new LatLng(43.5991700, 39.7256900), 13);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                setCameraPosition(marker.getPosition(), 16F);
                for (int i = 0; i < data.arrayListData.size(); i++) {
                    if (marker.getTitle().equals(data.arrayListData.get(i).getMarkerName())) {
                        textName.setText(data.arrayListData.get(i).getMarkerName());
                        textText.setText(data.arrayListData.get(i).getComent());
                        textUsver.setText(data.arrayListData.get(i).getCreater());
                        textPhone.setText(data.arrayListData.get(i).getPhone());
                    }
                }
                onClickButtonDialog();
                return false;
            }
        });
    }

    private void setCameraPosition(LatLng position, float zoom) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,zoom));
    }

    public void onClickButtonDialog() {
                d.show();
    }
}/*public void onClickList(View view){
        Dialog dialog;
        dialog = new Dialog(view.getContext());
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        // Передайте ссылку на разметку
        dialog.setContentView(R.layout.card);

        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }*/