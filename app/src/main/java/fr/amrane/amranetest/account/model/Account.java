package fr.amrane.amranetest.account.model;

import java.util.Locale;

import io.realm.RealmObject;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

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
    }
}
