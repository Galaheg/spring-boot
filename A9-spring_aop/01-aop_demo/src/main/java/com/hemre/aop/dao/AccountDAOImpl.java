package com.hemre.aop.dao;

import com.hemre.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{


    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " ADDING ACCOUNT");
        System.out.println(account.getName() + " " + account.getLevel());
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT, DUMMY FUNCTION");
        return true;
    }
}
