package com.bankAccount.BankAccountCRUD.service;

import com.bankAccount.BankAccountCRUD.ResourceNotFoundException;
import com.bankAccount.BankAccountCRUD.model.Account;
import com.bankAccount.BankAccountCRUD.model.AccountDetails;
import com.bankAccount.BankAccountCRUD.model.User;
import com.bankAccount.BankAccountCRUD.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;

    @Value("${user.ms.url}")
    private String userServiceUrl;

    public AccountServiceImpl(AccountRepository accountRepository, RestTemplate restTemplate) {
        this.accountRepository = accountRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public AccountDetails getAccountDetails(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        String userUrl = "http://localhost:8089/api/users/" + account.getUserId();  // Assuming User Service runs on port 8081
        User user = restTemplate.getForObject(userUrl, User.class);

        // Combine account data and user data in AccountDetails
        AccountDetails accountDetails = new AccountDetails(account, user);
        return accountDetails;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
