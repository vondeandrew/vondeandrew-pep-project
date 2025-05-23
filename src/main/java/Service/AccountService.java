package Service;

import Model.Account;
import DAO.AccountDAO;

import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO)
    {
        this.accountDAO = accountDAO;
    }

    public Account login(String userName, String password)
    {
        return this.accountDAO.login(userName, password);
    }

    Account insertAccount(Account newAccount)
    {
        String testUser = newAccount.getUsername();
        String testPass = newAccount.getPassword();
        if(testUser.trim().equals("") || testPass.length() < 4 || this.accountDAO.isIn(testUser))
        {
            return null;
        }
        return this.accountDAO.insertAccount(newAccount);
    }
}
