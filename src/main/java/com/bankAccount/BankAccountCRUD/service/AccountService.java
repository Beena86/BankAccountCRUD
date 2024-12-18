package com.bankAccount.BankAccountCRUD.service;

import com.bankAccount.BankAccountCRUD.model.Account;
import com.bankAccount.BankAccountCRUD.model.AccountDetails;

import java.util.List;

public interface AccountService {
    AccountDetails getAccountDetails(Long accountId);
    List<Account> getAllAccounts();
    Account createAccount(Account account);
    void deleteAccount(Long id);
}
