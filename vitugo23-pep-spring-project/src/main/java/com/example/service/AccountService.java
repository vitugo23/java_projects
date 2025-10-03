package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    public Account registerAccount(Account account) {
        // Check if username already exists
        if (accountRepository.findByUsername(account.getUsername()) != null) {
            return null;
        }
        
        // Username should not be blank and password should not be less than 4 characters
        if (account.getUsername() == null || account.getUsername().trim().isEmpty() || 
            account.getPassword() == null || account.getPassword().length() < 4) {
            return null;
        }
        
        return accountRepository.save(account);
    }
    
    public Account login(Account loginAttempt) {
        Account existingAccount = accountRepository.findByUsername(loginAttempt.getUsername());
        
        if (existingAccount != null && existingAccount.getPassword().equals(loginAttempt.getPassword())) {
            return existingAccount;
        }
        
        return null;
    }
    
    public Account getAccountById(Integer accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }
}
