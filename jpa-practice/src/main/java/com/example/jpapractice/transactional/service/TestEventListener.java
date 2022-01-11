package com.example.jpapractice.transactional.service;

import com.example.jpapractice.transactional.domain.entity.Test;
import com.example.jpapractice.transactional.domain.entity.TestAsyncEvent;
import com.example.jpapractice.transactional.domain.entity.TestEvent;
import com.example.jpapractice.transactional.domain.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.EntityManager;

@Slf4j
@RequiredArgsConstructor
@Component
public class TestEventListener {

    private final TestRepository testRepository;
    private final EntityManager entityManager;

    @TransactionalEventListener
    public void on(TestEvent testEvent) {
        Long id = testEvent.getId();
        entityManager.clear();
        Test test = testRepository.findById(id).get();
        log.info("{}", test.toString());
    }

    @Async
    @TransactionalEventListener
    public void on(TestAsyncEvent testAsyncEvent) {
        Long id = testAsyncEvent.getId();
        Test test = testRepository.findById(id).get();
        log.info("{}", test.toString());
    }

}
