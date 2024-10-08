package com.hemre.aop;

import com.hemre.aop.dao.AccountDAO;
import com.hemre.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {
			System.out.println("HELLO");
			//demoTheBeforeAdvice(accountDAO);
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// account methods
		accountDAO.addAccount(new Account("Emre", "five"), true);
		accountDAO.doWork();
		// membership methods
		membershipDAO.addAccount();
		membershipDAO.goToSleep();
	}

}
