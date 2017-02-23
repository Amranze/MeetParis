package fr.amrane.amranetest.account.repository;

import java.util.List;

import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.account.presenter.IBaseCallBack;
import io.realm.RealmResults;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public interface AccountRepository extends IBaseCallBack {
    interface onAddAccountCallBack{
        void onSuccess();
        void onError(String message);
    }
    interface onDeleteAccountCallBack{
        void onSuccess();
        void onError(String message);
    }
    interface onGetAccountCallBack{
        void onSuccess(Account account);
        void onError(String message);
    }
    interface ongetAllAccountCallBack{
        void onSuccess(RealmResults<Account> accounts);
        void onError(String message);
    }
    interface onGetAccountByMailCallBack{
        void onSuccess(Account account);
        void onError(String message);
    }
    interface onUpdateAccountCallBack{
        void onSuccess(Account account);
        void onError(String message);
    }

    interface onSearchAccountsByNameCallBack{
        void onSuccess(List<Account> accounts);
        void onError(String message);
    }
    void addAccount(Account account, onAddAccountCallBack callback);
    void getAccount(Account account, onGetAccountCallBack callback);
    void updateAccount(Account account, onUpdateAccountCallBack callback);
    void getAllAccounts(ongetAllAccountCallBack callback);
    void deleteAccount(String email, onDeleteAccountCallBack callback);
    void getAccountByMail(String email, onGetAccountByMailCallBack callback);
    void searchAccountsByNameOrSurname(String query, onSearchAccountsByNameCallBack callback);
    boolean checkUser(String email, String password);
    void getAccountByFirstName(String firstname);
    void getAccountByLastName(String lastname);
    //void addMessage(Message message);
}
