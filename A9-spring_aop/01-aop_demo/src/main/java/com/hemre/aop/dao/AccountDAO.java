package com.hemre.aop.dao;

import com.hemre.aop.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
