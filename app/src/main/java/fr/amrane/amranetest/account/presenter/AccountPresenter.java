package fr.amrane.amranetest.account.presenter;

import fr.amrane.amranetest.account.model.Account;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public interface AccountPresenter extends IBaseCallBack {
    void addAccount(Account account);
    void deleteAccount(String email);
    void getAccount(String email);
    void getAllAccounts();
    void getAccountByName(String name);
    void updateAccount(Account account);
}
