package com.hemre.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{


    @Override
    public void addAccount() {
        System.out.println(getClass() + " ADDING ACCOUNT");
    }
}
