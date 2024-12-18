package com.bankAccount.BankAccountCRUD.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountDetails {
    private Account account;
    private User user;
}
