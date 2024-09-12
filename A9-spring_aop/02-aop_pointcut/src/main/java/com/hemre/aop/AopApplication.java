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
			//demoTheBeforeAdvice(accountDAO, membershipDAO);
			//demoTheAfterReturningAdvice(accountDAO);
			//demoTheAfterThrowingAdvice(accountDAO);
			demoTheAfterAdvice(accountDAO);
		};
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {

		List<Account> accounts = null;

		try{
			boolean tripWire = true; // for academic purpose we simulate exception scene here
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\nMain Program: Caught Exception: " +
					exc);
		}
		System.out.println("\n\nAfter Advice");
		System.out.println("------");
		System.out.println(accounts);

	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {

		List<Account> accounts = null;

		try{
			boolean tripWire = true; // for academic purpose we simulate exception scene here
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\nMain Program: Caught Exception: " +
					exc);
		}
		System.out.println("\n\nAfter Throwing");
		System.out.println("------");
		System.out.println(accounts);

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
