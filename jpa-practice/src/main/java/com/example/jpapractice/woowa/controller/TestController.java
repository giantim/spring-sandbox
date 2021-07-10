package com.example.jpapractice.woowa.controller;

import com.example.jpapractice.woowa.domain.WeatherExtraFee;
import com.example.jpapractice.woowa.service.TestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("")
    public List<WeatherExtraFee> findAll() {
        return testService.findAll();
    }

    @PostMapping("")
    public void createWeatherExtraFee(@RequestBody Request request) {
        testService.save(request);
    }

    @PostMapping("/type")
    public void testMethod(@RequestBody Request2 request2) {
        System.out.println(request2.getNumber());
    }

    @Getter
    public static class Request2 {

        private int number;

        public Request2(int number) {
            this.number = number;
        }

    }

    @Getter
    public static class Request {

        private String weatherType;
        private double value;
        private int level;

    }

}
