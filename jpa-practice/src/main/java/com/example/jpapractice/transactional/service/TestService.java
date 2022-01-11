package com.example.jpapractice.transactional.service;

import com.example.jpapractice.transactional.domain.entity.Test;
import com.example.jpapractice.transactional.domain.entity.TestAsyncEvent;
import com.example.jpapractice.transactional.domain.entity.TestEvent;
import com.example.jpapractice.transactional.domain.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Test createTest(String name) {
        Test test = new Test(name);
        return testRepository.save(test);
    }

    @Transactional
    public Test updateTest(Long id, String name) {
        Test test = testRepository.findById(id).get();
        test.updateName(name);
        applicationEventPublisher.publishEvent(TestEvent.of(test));
        log.info("update test not async");
        return test;
    }

    @Transactional
    public Test updateAsync(Long id, String name) {
        Test test = testRepository.findById(id).get();
        test.updateName(name);
        applicationEventPublisher.publishEvent(TestAsyncEvent.of(test));
        return test;
    }
}
