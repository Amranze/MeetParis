package fr.amrane.amranetest.account.repository;

import java.util.ArrayList;
import java.util.List;

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
                .findAll();
        List<Account> accounts = new ArrayList<>(results.size());
        for (Account a : results) {
            Account copy = new Account(a);
            accounts.add(copy);
        }
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
    }
}
