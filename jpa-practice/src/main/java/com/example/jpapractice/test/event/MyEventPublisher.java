package com.example.jpapractice.test.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class MyEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void publish() {
        publishToComponent();
    }

    @Transactional
    public void nonTransactionalPublish() {
        eventPublisher.publishEvent(new NonTransactionalEvent("non transactional"));
    }

    private void publishToComponent() {
        eventPublisher.publishEvent(new MyEvent("hi"));
    }

    @Getter
    public static class MyEvent {

        private final String name;

        public MyEvent(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyEvent{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
