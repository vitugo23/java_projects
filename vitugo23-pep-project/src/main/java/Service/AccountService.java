package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account registerUser(String username, String password) {
        if (username == null || username.trim().isEmpty() || 
            password == null || password.length() < 4) {
            return null;
        }
        
        // Check if username already exists
        if (accountDAO.getAccountByUsername(username) != null) {
            return null;
        }
        
        return accountDAO.createAccount(new Account(username, password));
    }
    
    public Account loginUser(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        
        Account account = accountDAO.getAccountByUsername(username);
        if (account != null && account.getPassword().equals(password)) {
            return account;
        }
        return null;
    }
}


