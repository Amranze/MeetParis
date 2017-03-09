package fr.amrane.amranetest.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Amrane Ait Zeouay on 28-Feb-17.
 */

public class User {
    @JsonProperty("id")
    private String id;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("username")
    private String username;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("birthdate")
    private String birthdate;
    @JsonProperty("gender")
    private Details.Gender gender;
    @JsonProperty("age")
    private int age;
    @JsonProperty("phone")
    private String phone;
    //private Contact contact;
    @JsonProperty("userDetails")
    private Details userDetails;
    @JsonProperty("address")
    private String address;
    @JsonProperty("postalCode")
    private int postalCode;
    private String city;
    private String country;
    private long lastConnection;
    private long createdDate;
    //If the user doesn't connect from 3 months then set active to false
    private boolean active;
    private boolean online;
    //private List<Conversation> conversations;
    private Map<Integer, Conversation> conversations;
    private String profilePicture;
    private List<String> pictures;
    private List<Integer> likes;
    //whoSawMe to show people who saw the user
    private List<Integer> whoSawMe;
    //whoISaw to show user people that he/she saw
    private List<Integer> whoISaw;
    //TODO add social network
    private SocialNetwork socialNetworks;
    private double actualLocation;

    public User(){
    }

    public User(String firstname, String lastname, String mail, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
    }

    public User(String id, String firstname, String lastname, String username,
                String mail, String password, String birthdate, int age, Details.Gender gender,
                String phone, Details userDetails, String address, int postalCode, String city,
                String country, long lastConnection, long createdDate, boolean active, boolean online,
                Map<Integer, Conversation> conversations, List<String> pictures, String profilePicture,
                List<Integer> likes, List<Integer> whoSawMe, List<Integer> whoISaw,
                SocialNetwork socialNetworks) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.birthdate = birthdate;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.userDetails = userDetails;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.createdDate = createdDate;
        this.lastConnection = lastConnection;
        this.active = active;
        this.online = online;
        this.conversations = conversations;
        this.pictures = pictures;
        this.profilePicture = profilePicture;
        this.likes = likes;
        this.whoSawMe = whoSawMe;
        this.whoISaw = whoISaw;
        this.socialNetworks = socialNetworks;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
                + ", mail=" + mail + ", password=" + password + ", birthdate=" + birthdate + ", age=" + age + ", phone="
                + phone + ", address=" + address + ", postalCode=" + postalCode + ", city=" + city + ", country="
                + country + ", Gender=" + gender + ", lastConnection=" + lastConnection + ", createdDate="
                + createdDate + ", online=" + online + ", Active=" + active + ", conversations="+ conversations
                + ", profilePicture " + profilePicture + ", pictures=" + pictures + ", "+ "likes=" + likes
                + ", whoSawMe=" + whoSawMe + ", whoISaw=" + whoISaw + " socialNetworks " + socialNetworks
                + " Details " + (userDetails != null ? userDetails.toString() : null) + "]";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<Integer, Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(Map<Integer, Conversation> conversations) {
        this.conversations = conversations;
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
    public Details getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public Details.Gender getGender() {
        return gender;
    }
    public void setGender(Details.Gender gender) {
        this.gender = gender;
    }
    public double getActualLocation() {
        return actualLocation;
    }
    public void setActualLocation(double actualLocation) {
        this.actualLocation = actualLocation;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public long getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }
}
