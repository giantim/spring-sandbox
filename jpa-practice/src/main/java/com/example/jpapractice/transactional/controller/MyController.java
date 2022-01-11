package com.example.jpapractice.transactional.controller;

import com.example.jpapractice.test.event.MyEventPublisher;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/my")
@RestController
public class MyController {

    private final MyEventPublisher myEventPublisher;

    @GetMapping("/{shopNo}")
    public void shopNo(@PathVariable String shopNo) {
        System.out.println(shopNo);
    }

    @GetMapping
    public void supervisorZoneIds(@ModelAttribute SupervisorZoneRequest request) {
        List<Long> ids = request.getSupervisorZoneIds();
        ids.forEach(System.out::println);
    }

    @GetMapping("/event")
    public void printEvent() {
        myEventPublisher.publish();
    }

    @GetMapping("/event/non")
    public void printNonTransactionalEvent() {
        myEventPublisher.nonTransactionalPublish();
    }

    @Data
    private static class SupervisorZoneRequest {

        private List<Long> supervisorZoneIds;

    }

}
