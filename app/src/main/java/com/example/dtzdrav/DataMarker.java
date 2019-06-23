package com.example.dtzdrav;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DataMarker {
    private int numArray;
    private int id;
    private double v;
    private double v1;
    private String markerName;
    private String creater;
    private String pharmacyAdress;
    private String createrAdress;
    private String phone;
    private String drugList;
    private String cellAdress;
    private String coment;
    private LatLng latLng;

    public DataMarker(String data){
        String[] strings = data.split("%");
        String[] strings1 = strings[0].split("=");
        this.id = Integer.parseInt(strings1[1]);
        strings1 = strings[1].split("=");
        this.v = Double.parseDouble(strings1[1]);
        strings1 = strings[2].split("=");
        this.v1= Double.parseDouble(strings1[1]);
        strings1 = strings[3].split("=");
        this.markerName = strings1[1];
        strings1 = strings[4].split("=");
        this.creater = strings1[1];
        strings1 = strings[5].split("=");
        this.pharmacyAdress = strings1[1];
        strings1 = strings[6].split("=");
        this.createrAdress = strings1[1];
        strings1 = strings[7].split("=");
        this.phone = strings1[1];
        strings1 = strings[8].split("=");
        this.drugList = strings1[1];
        strings1 = strings[9].split("=");
        this.cellAdress = strings1[1];
        strings1 = strings[10].split("=");
        this.coment = strings1[1];
        this.latLng = new LatLng(v, v1);
    }

    public DataMarker(int id, Double v, Double v1, String markerName, String creater, String pharmacyAdress, String createrAdress, String phone, String drugList, String cellAdress, String coment){
        this.id = id;
        this.v = v;
        this.v1= v1;
        this.markerName = markerName;
        this.creater = creater;
        this.pharmacyAdress = pharmacyAdress;
        this.createrAdress = createrAdress;
        this.phone = phone;
        this.drugList = drugList;
        this.cellAdress = cellAdress;
        this.coment = coment;
        this.latLng = new LatLng(v, v1);
    }

    public DataMarker(int id, LatLng latLng, String markerName, String creater, String pharmacyAdress, String createrAdress, String phone, String drugList, String cellAdress, String coment){
        this.id = id;
        this.markerName = markerName;
        this.creater = creater;
        this.pharmacyAdress = pharmacyAdress;
        this.createrAdress = createrAdress;
        this.phone = phone;
        this.drugList = drugList;
        this.cellAdress = cellAdress;
        this.coment = coment;
        this.latLng = latLng;
    }

    public int getId() {
        return id;
    }

    public String getMarkerName() {
        return markerName;
    }

    public String getCreater() {
        return creater;
    }

    public String getPharmacyAdress() {
        return pharmacyAdress;
    }

    public String getCreaterAdress() {
        return createrAdress;
    }

    public String getPhone() {
        return phone;
    }

    public String getDrugList() {
        return drugList;
    }

    public String getCellAdress() {
        return cellAdress;
    }

    public String getComent() {
        return coment;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public int getNumArray() {
        return numArray;
    }

    public void setNumArray(int numArray) {
        this.numArray = numArray;
    }
}
