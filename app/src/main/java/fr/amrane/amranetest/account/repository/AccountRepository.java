package fr.amrane.amranetest.account.repository;

import java.util.List;

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
}
