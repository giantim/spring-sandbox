package com.example.jpapractice.transactional.service;

import lombok.Getter;

@Getter
public class CustomBean {

    private String title;

    public CustomBean(String title) {
        this.title = title;
    }
}
