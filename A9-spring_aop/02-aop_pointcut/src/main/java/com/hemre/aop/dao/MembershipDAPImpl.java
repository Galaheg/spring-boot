package com.hemre.aop.dao;

import com.hemre.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAPImpl implements MembershipDAO{

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + " ADDING Member: " + account.getName());
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": gotta sleep");
    }
}
