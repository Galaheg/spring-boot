package com.hemre.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAPImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + " ADDING Member");
    }
}
