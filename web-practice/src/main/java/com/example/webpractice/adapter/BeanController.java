package com.example.webpractice.adapter;

import com.example.webpractice.application.BaeminOneOrderProcessor;
import com.example.webpractice.application.OrderProcessor;
import com.example.webpractice.application.OrderProcessorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/bean")
@RestController
public class BeanController {

    private final OrderProcessorFactory customOrderProcessorFactory;

    public BeanController(OrderProcessorFactory customOrderProcessorFactory) {
        this.customOrderProcessorFactory = customOrderProcessorFactory;
    }

    @GetMapping
    public ResponseEntity<Void> getOrderProcessor(@RequestParam("name") String name) {
        OrderProcessor orderProcessor = customOrderProcessorFactory.getOrderProcessor(name);
        orderProcessor.doProcess();

        return ResponseEntity.ok().build();
    }

    @Configuration
    static class BeanControllerConfiguration {

        @Bean(name = "customOrderProcessorFactory")
        public OrderProcessorFactory orderProcessorFactory(BaeminOneOrderProcessor baeminOneOrderProcessor) {
            return new OrderProcessorFactory(List.of(baeminOneOrderProcessor));
        }
    }
}
