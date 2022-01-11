package com.example.jpapractice.transactional.domain.entity;

import lombok.Getter;

@Getter
public class TestEvent {

    private Long id;
    private String name;

    private TestEvent() {
    }

    public static TestEvent of(Test test) {
        TestEvent testEvent = new TestEvent();
        testEvent.id = test.getId();
        testEvent.name = test.getName();
        return testEvent;
    }

}
