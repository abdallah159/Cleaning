package iti.abdallah.cleaning.model;

import java.io.Serializable;

public class Carpet implements Serializable {

    private int number;
    private String width;
    private String height;

    public Carpet(int number, String width, String height) {
        this.number = number;
        this.width = width;
        this.height = height;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
