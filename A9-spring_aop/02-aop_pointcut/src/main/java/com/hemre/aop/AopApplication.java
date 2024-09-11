package com.hemre.aop;

import com.hemre.aop.dao.AccountDAO;
import com.hemre.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {
			System.out.println("IN RUNNER");
			//demoTheBeforeAdvice(accountDAO);
			demoTheBeforeAdvice(accountDAO, membershipDAO);
			demoTheAfterReturningAdvice(accountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nAfter Return");
		System.out.println("------");
		System.out.println(accounts);

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// account methods
		accountDAO.addAccount(new Account("Emre", "five"), true);
		accountDAO.doWork();
		accountDAO.setName("Personal");
		accountDAO.setServiceCode("01");
		accountDAO.getName();
		accountDAO.getServiceCode();

		// membership methods
		membershipDAO.addAccount(new Account("Emre", "five"));
		membershipDAO.goToSleep();
	}

}
