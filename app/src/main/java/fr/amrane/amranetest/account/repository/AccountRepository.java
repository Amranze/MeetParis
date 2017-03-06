package fr.amrane.amranetest.account.repository;

import java.util.List;

<<<<<<< HEAD
import fr.amrane.amranetest.account.exception.AccountDoesNotExistException;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.common.repository.AbsInjectableFactory;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public interface AccountRepository {
    Account getAccount(String email) throws AccountDoesNotExistException;
    List<Account> getAllAccounts();
    List<Account> searchAccountsByNameOrSurname(String query);
    void saveAccount(Account account);
    void removeAccount(Account account);
    void removeAccounts(List<Account> accounts);
    void updateAccount(Account account);

    class InjectableFactory extends AbsInjectableFactory<AccountRepository> {

        public static final InjectableFactory INSTANCE = new InjectableFactory();

        private InjectableFactory(){
            //empty constructor
        }

        @Override
        protected AccountRepository createInstance() {
            return new AccountRepositoryImpl();
        }
    }
=======
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
    Account getCurrentUser();
    //void addMessage(Message message);
>>>>>>> feature/sprint/1/Fixing_Profile_Screen
}
