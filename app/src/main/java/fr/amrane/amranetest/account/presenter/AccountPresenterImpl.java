package fr.amrane.amranetest.account.presenter;

import java.util.List;

import fr.amrane.amranetest.Activity.LoginActivity;
import fr.amrane.amranetest.Activity.SignupActivity;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.account.repository.AccountRepository;
import fr.amrane.amranetest.account.repository.AccountRepositoryImpl;
import io.realm.RealmResults;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class AccountPresenterImpl implements AccountPresenter {

    private SignupActivity signupView;
    private LoginActivity loginView;

    private AccountRepository.onAddAccountCallBack onAddAccountCallBack;
    private AccountRepository.onDeleteAccountCallBack onDeleteAccountCallBack;
    private AccountRepository.onGetAccountCallBack onGetAccountCallBack;
    private AccountRepository.ongetAllAccountCallBack ongetAllAccountCallBack;
    private AccountRepository.onGetAccountByMailCallBack onGetAccountByMailCallBack;
    private AccountRepository.onSearchAccountsByNameCallBack onSearchAccountsByNameCallBack;
    private AccountRepository.onUpdateAccountCallBack onUpdateAccountCallBack;

    private AccountRepository accountRepository;

    public AccountPresenterImpl(SignupActivity view){
        this.signupView = view;
        accountRepository = new AccountRepositoryImpl();
    }

    public AccountPresenterImpl(LoginActivity view){
        this.loginView = view;
        accountRepository = new AccountRepositoryImpl();
    }

    @Override
    public void addAccount(Account account) {
        accountRepository.addAccount(account, onAddAccountCallBack);
    }

    @Override
    public void deleteAccount(String email) {

    }

    @Override
    public void getAccount(String email) {

    }

    @Override
    public void getAllAccounts() {

    }

    @Override
    public void getAccountByName(String name) {

    }

    @Override
    public void updateAccount(Account account) {

    }


    @Override
    public void subscribeCallbacks() {
        onAddAccountCallBack = new AccountRepository.onAddAccountCallBack() {
            @Override
            public void onSuccess() {
                //signupView.showMessage("Added");
            }

            @Override
            public void onError(String message) {
                //signupView.showMessage(message);
            }
        };

        onDeleteAccountCallBack = new AccountRepository.onDeleteAccountCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(String message) {
                //signupView.showMessage(message);
            }
        };

        onGetAccountCallBack = new AccountRepository.onGetAccountCallBack() {
            @Override
            public void onSuccess(Account account) {

            }

            @Override
            public void onError(String message) {
                //signupView.showMessage(message);
            }
        };

        ongetAllAccountCallBack = new AccountRepository.ongetAllAccountCallBack() {
            @Override
            public void onSuccess(RealmResults<Account> accounts) {

            }

            @Override
            public void onError(String message) {
                //signupView.showMessage(message);
            }
        };

        onGetAccountByMailCallBack = new AccountRepository.onGetAccountByMailCallBack() {
            @Override
            public void onSuccess(Account account) {

            }

            @Override
            public void onError(String message) {
                //signupView.showMessage(message);
            }
        };

        onSearchAccountsByNameCallBack = new AccountRepository.onSearchAccountsByNameCallBack() {
            @Override
            public void onSuccess(List<Account> accounts) {

            }

            @Override
            public void onError(String message) {
                //signupView.showMessage(message);
            }
        };

        onUpdateAccountCallBack = new AccountRepository.onUpdateAccountCallBack() {
            @Override
            public void onSuccess(Account account) {

            }

            @Override
            public void onError(String message) {
                //signupView.showMessage(message);
            }
        };
    }

    @Override
    public void unSubscribeCallbacks() {
        onAddAccountCallBack = null;
        onDeleteAccountCallBack = null;
        onGetAccountCallBack = null;
        ongetAllAccountCallBack = null;
        onGetAccountByMailCallBack = null;
        onSearchAccountsByNameCallBack = null;
        onUpdateAccountCallBack = null;
    }
}
