package fr.amrane.amranetest.account.repository;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import fr.amrane.amranetest.account.exception.AccountDoesNotExistException;
import fr.amrane.amranetest.account.model.Account;
import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class AccountRepositoryImpl implements AccountRepository {
    private static final String EMAIL = "email";

    @Override
    public Account getAccount(String email) throws AccountDoesNotExistException {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Account> results = realm.where(Account.class)
                .equalTo(EMAIL, email)
                .findAll();
        if (results.size() == 0) {
            realm.close();
            throw new AccountDoesNotExistException();
        }
        Account account = new Account(results.get(0));
        realm.close();
        return account;
    }

    @Override
    public List<Account> getAllAccounts() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Account> results = realm.where(Account.class).findAll();
        List<Account> accounts = new ArrayList<>(results.size());
        for (Account a : results) {
            Account copy = new Account(a);
            accounts.add(copy);
        }
        realm.close();
        return accounts;
    }

    @Override
    public List<Account> searchAccountsByNameOrSurname(String query) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Account> results = realm
                .where(Account.class)
                .beginsWith(Account.F_NAME, query, Case.INSENSITIVE)
                .or()
                .beginsWith(Account.F_SURNAME, query, Case.INSENSITIVE)
=======
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
    private static Account currentUser;

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
        currentUser = account;
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
        currentUser = account;
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
        currentUser = null;
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
>>>>>>> feature/sprint/1/Fixing_Profile_Screen
                .findAll();
        List<Account> accounts = new ArrayList<>(results.size());
        for (Account a : results) {
            Account copy = new Account(a);
            accounts.add(copy);
        }
<<<<<<< HEAD
        realm.close();
        return accounts;
    }

    @Override
    public void saveAccount(Account account) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(account);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void removeAccount(Account account) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Account> results = realm.where(Account.class)
                .equalTo(Account.F_EMAIL, account.getEmail()).findAll();
        results.deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void removeAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            removeAccount(account);
        }
    }

    @Override
    public void updateAccount(Account account) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Account result = realm.where(Account.class)
                .equalTo(Account.F_EMAIL, account.getEmail())
                .findFirst();
        result.setName(account.getName());
        result.setSurname(account.getSurname());
        result.setEmail(account.getEmail());
        realm.commitTransaction();
        realm.close();
=======
        if (callback != null)
            callback.onSuccess(accounts);
        realm.close();
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
        if(accounts.size() != 0){
            currentUser = accounts.first();
            return true;
        }
        return false;
    }

    @Override
    public void getAccountByFirstName(String firstname) {

    }

    @Override
    public void getAccountByLastName(String lastname) {

    }

    @Override
    public Account getCurrentUser() {
        return currentUser;
    }

    @Override
    public void subscribeCallbacks() {

    }

    @Override
    public void unSubscribeCallbacks() {

>>>>>>> feature/sprint/1/Fixing_Profile_Screen
    }
}
