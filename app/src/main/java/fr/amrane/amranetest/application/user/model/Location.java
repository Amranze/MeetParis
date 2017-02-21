package fr.amrane.amranetest.application.user.model;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class Location {
    private String address;
    private String city;
    private String department;
    private String country;

    public Location(String address, String city, String country, String department) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
