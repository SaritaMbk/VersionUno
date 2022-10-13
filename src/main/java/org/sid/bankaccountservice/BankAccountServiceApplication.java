package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.BankAcount;
import org.sid.bankaccountservice.enums.AccountType;
import org.sid.bankaccountservice.repositories.BankAcountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAcountRepository bankAcountRepository){
		return args -> {
			for (int i = 0; i<10; i++) {
				BankAcount bankAcount = BankAcount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT :AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()+90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				bankAcountRepository.save(bankAcount);

			}
		};

	}

}
