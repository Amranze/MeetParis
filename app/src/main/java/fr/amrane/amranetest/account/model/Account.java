package fr.amrane.amranetest.account.model;

<<<<<<< HEAD
import java.util.Locale;

import io.realm.RealmObject;
=======
import java.io.Serializable;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
>>>>>>> feature/sprint/1/Fixing_Profile_Screen

/**
 * Created by aaitzeouay on 21/02/2017.
 */

<<<<<<< HEAD
public class Account extends RealmObject {
    public static final String F_ID = "id";
    public static final String F_NAME = "name";
    public static final String F_SURNAME = "surname";
    public static final String F_EMAIL = "email";

    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean passwordChanged;
    public Account(){
        passwordChanged = true;
    }

    public Account(Account a){
        id = a.getId();
        name = a.getName();
        surname = a.getSurname();
        email = a.getEmail();
        passwordChanged = a.isPasswordChanged();
    }


    public String getNameAndSurname(){
        return String.format(Locale.getDefault(),
                "%s %s",getName(),getSurname());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return id == account.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
=======
public class Account extends RealmObject implements Serializable {
    private String firstname, lastname, password;
    private Date birthdate;
    private String picture;
    @PrimaryKey
    private String mail;

    public Account() {
    }

    public Account(Date birthdate, String firstname, String lastname, String mail, String password) {
        this.birthdate = birthdate;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
    }
    public Account(Account a){
        this.birthdate = a.getBirthdate();
        this.firstname = a.getFirstname();
        this.lastname = a.getLastname();
        this.mail = a.getMail();
        this.password = a.getMail();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    @Override
    public String toString() {
        return "Account{" +
                "birthdate=" + birthdate +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
>>>>>>> feature/sprint/1/Fixing_Profile_Screen
    }
}
