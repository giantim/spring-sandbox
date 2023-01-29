package com.example.webpractice.application;

import org.springframework.stereotype.Component;

@Component
public class BaeminOneOrderProcessor implements OrderProcessor {

    @Override
    public void doProcess() {
        System.out.println("baemin one");
    }

    @Override
    public boolean isType(String type) {
        return "baemin".equals(type);
    }
}
