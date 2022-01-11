package com.example.jpapractice.test.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class MyEventListenerTwo {

//    @Async
    @TransactionalEventListener
    public void printEvent(MyEventPublisher.MyEvent event) {
        log.info("event listener 2: {}", event.getName());
    }

}
