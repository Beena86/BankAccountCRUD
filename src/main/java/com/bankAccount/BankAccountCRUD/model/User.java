package com.bankAccount.BankAccountCRUD.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String username;
    private String email;
    private String phoneNumber;
    private String kycStatus;
}
