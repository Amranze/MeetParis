package fr.amrane.amranetest.general.auth;

import java.util.List;

import fr.amrane.amranetest.account.model.Account;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public interface AuthRepository {
    void addAuthAccount(String email, String password);
    void login(String email,String password);
    void logout() ;
    void changePassword(String email,String currentPassword,String newPassword);
    void resetPassword(String email,String newPassword);
    Account getLoggedInAccount();
    Account getAuthAccount(String email);
    void removeAuthAccount(Account account);
    void removeAuthAccounts(List<Account> accounts);
    boolean testIfAccountExists(String email);
}
