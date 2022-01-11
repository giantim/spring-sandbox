package com.example.jpapractice.test.domain;

import com.example.jpapractice.test.TestConfiguration;
import com.example.jpapractice.transactional.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestConfiguration.class)
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        try {
            throw new IllegalArgumentException();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

}