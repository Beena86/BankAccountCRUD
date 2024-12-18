package com.bankAccount.BankAccountCRUD.model;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private Long userId;
    private String accountNumber;
    private String accountType;
    @NotNull
    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
    private String currency = "USD";

//    @Column(nullable = false)
//    private LocalDateTime createdAt = LocalDateTime.now();

}
