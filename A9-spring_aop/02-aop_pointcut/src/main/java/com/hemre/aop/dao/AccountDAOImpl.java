package com.hemre.aop.dao;

import com.hemre.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{


    private String name;
    private String serviceCode;

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

    public String getName() {
        System.out.println(getClass() + ": in getName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    @Override
    public List<Account> findAccounts(){
        return findAccounts(false);//dont throw exception
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) throws RuntimeException {

        if(tripWire){
            throw new RuntimeException("Nah.. try again");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account acc1 = new Account("Berfin", "platinum");
        Account acc2 = new Account("Emre", "gold");
        Account acc3 = new Account("Dummy", "cooper");

        myAccounts.add(acc1);
        myAccounts.add(acc2);
        myAccounts.add(acc3);
        return myAccounts;

    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");

        this.serviceCode = serviceCode;
    }
}
