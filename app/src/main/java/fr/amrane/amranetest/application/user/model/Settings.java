package fr.amrane.amranetest.application.user.model;

import java.util.List;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class Settings {
    private int distance;
    //genderInterest 0 is woman 1 for men 2 for both
    private int genderInterest;
    private int age;
    //distanceFormat true if Km false otherwise
    private boolean distanceFormat;
    //notifications to show on the phone
    private List<Boolean> notifications;
}
