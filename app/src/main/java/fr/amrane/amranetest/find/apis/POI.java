package fr.amrane.amranetest.find.apis;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class POI {
    private String name;
    private LatLng location;

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
