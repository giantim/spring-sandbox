package com.example.jpapractice.transactional.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class TestAsyncEvent {

    private Long id;
    private String name;

    public static TestAsyncEvent of(Test test) {
        TestAsyncEvent testAsyncEvent = new TestAsyncEvent();
        testAsyncEvent.id = test.getId();
        testAsyncEvent.name = test.getName();
        return testAsyncEvent;
    }

}
