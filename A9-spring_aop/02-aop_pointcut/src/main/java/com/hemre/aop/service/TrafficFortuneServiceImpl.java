package com.hemre.aop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() throws RuntimeException{

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return " EXPECT rain";
    }

    @Override
    public String getFortune(boolean tripWire) throws RuntimeException{

        if (tripWire)
            throw new RuntimeException("Major accident");

        return getFortune();
    }
}
