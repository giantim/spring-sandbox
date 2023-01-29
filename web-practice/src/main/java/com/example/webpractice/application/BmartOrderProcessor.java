package com.example.webpractice.application;

import org.springframework.stereotype.Component;

@Component
public class BmartOrderProcessor implements OrderProcessor {

    @Override
    public void doProcess() {
        System.out.println("bmart");
    }

    @Override
    public boolean isType(String type) {
        return "bmart".equals(type);
    }
}
