package com.bankAccount.BankAccountCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bankAccount.BankAccountCRUD.repository") // Scans repositories
@EntityScan(basePackages = "com.bankAccount.BankAccountCRUD.model")
public class BankAccountCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountCrudApplication.class, args);
	}

}
