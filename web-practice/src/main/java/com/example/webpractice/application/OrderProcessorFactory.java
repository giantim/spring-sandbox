package com.example.webpractice.application;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderProcessorFactory {

    private final List<OrderProcessor> orderProcessors;

    public OrderProcessorFactory(List<OrderProcessor> orderProcessors) {
        this.orderProcessors = orderProcessors;
    }

    public OrderProcessor getOrderProcessor(String type) {
        return orderProcessors.stream()
                .filter(orderProcessor -> orderProcessor.isType(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("type에 해당하는 프로세서가 존재하지 않습니다."));
    }
}
