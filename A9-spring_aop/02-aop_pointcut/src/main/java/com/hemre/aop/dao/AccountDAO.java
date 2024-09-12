package com.hemre.aop.dao;

import com.hemre.aop.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    void setName(String name);

    void setServiceCode(String serviceCode);

    String getName();

    String getServiceCode();

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
