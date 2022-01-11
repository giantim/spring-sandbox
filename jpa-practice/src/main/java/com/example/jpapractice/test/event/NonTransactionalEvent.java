package com.example.jpapractice.test.event;

import lombok.Getter;

@Getter
public class NonTransactionalEvent {

    private String name;

    public NonTransactionalEvent(String name) {
        this.name = name;
    }

}
