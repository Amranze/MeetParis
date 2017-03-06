package fr.amrane.amranetest.account.model;

import java.util.Date;
import java.util.List;

/**
 * Created by aaitzeouay on 01/03/2017.
 */

public class User {
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String mail;
    private String password;
    private String birthdate;
    private Details.Gender gender;
    private int age;
    private String phone;
    private Details userDetails;
    private String address;
    private int postalCode;
    private String city;
    private String country;
    private long lastConnection;
    private long createdDate;
    private boolean active;
    private boolean online;
    private String profilePicture;
    private List<String> pictures;
    private List<Integer> likes;
    private List<Integer> whoSawMe;
    private List<Integer> whoISaw;
    private SocialNetwork socialNetworks;
    private double actualLocation;

    public User() {
    }

    public User(long id, String firstname, String lastname, String username, String mail, String password, String birthdate, Details.Gender gender,
                int age, String phone, Details userDetails, String address, int postalCode, String city, String country, long lastConnection,
                long createdDate, boolean active, boolean online, String profilePicture, List<String> pictures, List<Integer> likes, List<Integer> whoSawMe,
                List<Integer> whoISaw, SocialNetwork socialNetworks, double actualLocation) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.userDetails = userDetails;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.lastConnection = lastConnection;
        this.createdDate = createdDate;
        this.active = active;
        this.online = online;
        this.profilePicture = profilePicture;
        this.pictures = pictures;
        this.likes = likes;
        this.whoSawMe = whoSawMe;
        this.whoISaw = whoISaw;
        this.socialNetworks = socialNetworks;
        this.actualLocation = actualLocation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Details.Gender getGender() {
        return gender;
    }

    public void setGender(Details.Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
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

    public long getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(long lastConnection) {
        this.lastConnection = lastConnection;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<Integer> getLikes() {
        return likes;
    }

    public void setLikes(List<Integer> likes) {
        this.likes = likes;
    }

    public List<Integer> getWhoSawMe() {
        return whoSawMe;
    }

    public void setWhoSawMe(List<Integer> whoSawMe) {
        this.whoSawMe = whoSawMe;
    }

    public List<Integer> getWhoISaw() {
        return whoISaw;
    }

    public void setWhoISaw(List<Integer> whoISaw) {
        this.whoISaw = whoISaw;
    }

    public SocialNetwork getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(SocialNetwork socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public double getActualLocation() {
        return actualLocation;
    }

    public void setActualLocation(double actualLocation) {
        this.actualLocation = actualLocation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", userDetails=" + userDetails.toString() +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", lastConnection=" + lastConnection +
                ", createdDate=" + createdDate +
                ", active=" + active +
                ", online=" + online +
                ", profilePicture='" + profilePicture + '\'' +
                ", pictures=" + pictures +
                ", likes=" + likes +
                ", whoSawMe=" + whoSawMe +
                ", whoISaw=" + whoISaw +
                ", socialNetworks=" + socialNetworks.toString() +
                ", actualLocation=" + actualLocation +
                '}';
    }
}
