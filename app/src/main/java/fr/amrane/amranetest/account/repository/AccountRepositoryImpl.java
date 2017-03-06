package fr.amrane.amranetest.account.repository;

import java.util.ArrayList;
import java.util.List;

import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.application.App;
import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void addAccount(Account account, onAddAccountCallBack callback) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        /*Account realmAccount = realm.createObject(Account.class);
        realmAccount.setFirstname(account.getFirstname());
        realmAccount.setLastname(account.getLastname());
        realmAccount.setMail(account.getMail());
        realmAccount.setPassword(account.getPassword());
        realmAccount.setBirthdate(account.getBirthdate());*/
        realm.copyToRealm(account);
        realm.commitTransaction();
        if (callback != null)
            callback.onSuccess();
        realm.close();
    }

    @Override
    public void getAccount(Account account, onGetAccountCallBack callback) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Account realmAccount = realm.where(Account.class)
                .equalTo(RealmTableSchema.EMAIL, account.getMail())
                .equalTo(RealmTableSchema.PASSWORD, account.getPassword())
                .findFirst();

        if (callback != null)
            callback.onSuccess(realmAccount);
        realm.close();
    }

    @Override
    public void updateAccount(Account account, onUpdateAccountCallBack callback) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Account result = realm.where(Account.class)
                .equalTo(RealmTableSchema.EMAIL, account.getMail())
                .findFirst();
        result.setFirstname(account.getFirstname());
        result.setLastname(account.getLastname());
        result.setPassword(account.getPassword());
        result.setBirthdate(account.getBirthdate());
        realm.commitTransaction();
        if (callback != null)
            callback.onSuccess(result);
        realm.close();
    }

    @Override
    public void getAllAccounts(ongetAllAccountCallBack callback) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Account> accounts = realm.where(Account.class).findAll();
        if (accounts.size() == 0) {
            realm.close();
            if (callback != null)
                callback.onError("There is no Account");
        }
        if (callback != null)
            callback.onSuccess(accounts);
        realm.close();
    }

    @Override
    public void deleteAccount(String email, onDeleteAccountCallBack callback) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Account> account = realm.where(Account.class).equalTo(RealmTableSchema.EMAIL, email).findAll();
        account.deleteAllFromRealm();
        realm.commitTransaction();
        if (callback != null)
            callback.onSuccess();
        realm.close();
    }

    @Override
    public void getAccountByMail(String email, onGetAccountByMailCallBack callback) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Account accounts = realm.where(Account.class).equalTo(RealmTableSchema.EMAIL, email).findFirst();

        realm.commitTransaction();
        if (callback != null)
            callback.onSuccess(accounts);
        realm.close();

    }

    @Override
    public void searchAccountsByNameOrSurname(String query, onSearchAccountsByNameCallBack callback) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Account> results = realm
                .where(Account.class)
                .beginsWith(RealmTableSchema.FIRSTNAME, query, Case.INSENSITIVE)
                .or()
                .beginsWith(RealmTableSchema.LASTNAME, query, Case.INSENSITIVE)
                .findAll();
        List<Account> accounts = new ArrayList<>(results.size());
        for (Account a : results) {
            Account copy = new Account(a);
            accounts.add(copy);
        }
        if (callback != null)
            callback.onSuccess(accounts);
        realm.close();
    }

    @Override
    public boolean checkUser(String email, String password) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Account> accounts = realm.where(Account.class)
                .equalTo(RealmTableSchema.EMAIL, email)
                .equalTo(RealmTableSchema.PASSWORD, password)
                .findAll();
        realm.close();
        return (accounts.size() == 0);
    }

    @Override
    public void getAccountByFirstName(String firstname) {

    }

    @Override
    public void getAccountByLastName(String lastname) {

    }

    @Override
    public void subscribeCallbacks() {

    }

    @Override
    public void unSubscribeCallbacks() {

    }
}
