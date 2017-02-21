package fr.amrane.amranetest.application.user.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.realm.RealmObject;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class User extends RealmObject {
    private long id;
    private String username;
    private String firstname;
    private String lasttname;
    private String mail;
    private String password;
    private int phoneNumber;
    private Date birthday;
    private int age;
    private String address;
    private Location location;
    private String profilePicture;
    private List<String> pictures;
    private List<String> likes;
    private List<String> whoSawMe;
    private List<String> whoIsaw;
    private SocialNetwork socialNetwork;
    private Settings settings;
    private Friends friends;

    public User(String address, int age, Date birthday, String firstname,
                Friends friends, long id, String lasttname, List<String> likes, Location location, String mail,
                String password, int phoneNumber, List<String> pictures, String profilePicture, Settings settings,
                SocialNetwork socialNetwork, String username, List<String> whoIsaw, List<String> whoSawMe) {
        this.address = address;
        this.age = age;
        this.birthday = birthday;
        this.firstname = firstname;
        this.friends = friends;
        this.id = id;
        this.lasttname = lasttname;
        this.likes = likes;
        this.location = location;
        this.mail = mail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.pictures = pictures;
        this.profilePicture = profilePicture;
        this.settings = settings;
        this.socialNetwork = socialNetwork;
        this.username = username;
        this.whoIsaw = whoIsaw;
        this.whoSawMe = whoSawMe;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Friends getFriends() {
        return friends;
    }

    public void setFriends(Friends friends) {
        this.friends = friends;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLasttname() {
        return lasttname;
    }

    public void setLasttname(String lasttname) {
        this.lasttname = lasttname;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getWhoIsaw() {
        return whoIsaw;
    }

    public void setWhoIsaw(List<String> whoIsaw) {
        this.whoIsaw = whoIsaw;
    }

    public List<String> getWhoSawMe() {
        return whoSawMe;
    }

    public void setWhoSawMe(List<String> whoSawMe) {
        this.whoSawMe = whoSawMe;
    }
}

class Friends{
    private String fullname;
    private String profilePicture;
    private int age;

    public Friends(int age, String fullname, String profilePicture) {
        this.age = age;
        this.fullname = fullname;
        this.profilePicture = profilePicture;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
