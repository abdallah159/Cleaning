package iti.abdallah.cleaning.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Location implements Serializable {

    private LatLng latLng;
    private String street;

    public Location(LatLng latLng) {
        this.latLng = latLng;
    }

    public Location(LatLng latLng, String street) {
        this.latLng = latLng;
        this.street = street;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latLng=" + latLng +
                ", street='" + street + '\'' +
                '}';
    }
}
