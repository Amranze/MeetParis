package fr.amrane.amranetest.account.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class Account extends RealmObject {
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
    }
}
