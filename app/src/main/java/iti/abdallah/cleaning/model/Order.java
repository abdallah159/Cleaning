package iti.abdallah.cleaning.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {

    private String serviceType = "normal";
    private String paymentType = "cash";
    private Location location;
    private ArrayList<Carpet> carpets;

    public ArrayList<Carpet> getCarpets() {
        return carpets;
    }

    public void setCarpets(ArrayList<Carpet> carpets) {
        this.carpets = carpets;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Order{" +
                "serviceType='" + serviceType + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", location=" + location +
                ", carpets=" + carpets +
                '}';
    }
}
