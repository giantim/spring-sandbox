package com.example.jpapractice.test.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class NonTransactionalListener {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    public void on(NonTransactionalEvent event) {
        System.out.println(event.getName());
    }

}
