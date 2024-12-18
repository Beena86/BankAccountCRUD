package com.bankAccount.BankAccountCRUD.controller;


import com.bankAccount.BankAccountCRUD.model.Account;
import com.bankAccount.BankAccountCRUD.model.AccountDetails;
import com.bankAccount.BankAccountCRUD.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @GetMapping("/{accountId}")

    public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable Long accountId) {
        AccountDetails accountDetails = accountService.getAccountDetails(accountId);
        return ResponseEntity.ok(accountDetails);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account request) {
        Account account = accountService.createAccount(request);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
