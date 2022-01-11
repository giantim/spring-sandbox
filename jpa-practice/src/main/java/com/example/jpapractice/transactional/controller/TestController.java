package com.example.jpapractice.transactional.controller;

import com.example.jpapractice.transactional.domain.entity.Test;
import com.example.jpapractice.transactional.dto.ChildDto;
import com.example.jpapractice.transactional.service.TestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    private final RestOperations restOperations;
    private final TestService testService;

    @GetMapping("/go-post")
    public void goPost() {
        List<Long> riderIds = Arrays.asList(1L, 2L, 3L);
        RiderLocation[] riderLocations = restOperations.postForObject("http://localhost:8085/post/rider-ids-by-long", riderIds, RiderLocation[].class);
        Arrays.stream(riderLocations).forEach(System.out::println);
    }

    @Getter
    @Setter
    private static class RiderLocation {
        private Long latitude;
        private Long longitude;

        @Override
        public String toString() {
            return "latitude:" + latitude + ", longitude: " + longitude;
        }
    }

    @GetMapping("")
    public void test(@ModelAttribute ChildDto childDto) {
        System.out.println(childDto.toString());
    }

    @GetMapping("/hi")
    public void test2(@ModelAttribute ChildDto childDto) {
        System.out.println(childDto.toString());
    }

    @PostMapping("/{name}")
    public void createTest(@PathVariable String name) {
        Test test = testService.createTest(name);
        log.info("{}", test.toString());
    }

    @PutMapping("/update/{id}/{name}")
    public void updateTest(@PathVariable Long id, @PathVariable String name) {
        Test test = testService.updateTest(id, name);
        log.info("{}", test.toString());
    }

    @PutMapping("/update/async/{id}/{name}")
    public void updateAsyncTest(@PathVariable Long id, @PathVariable String name) {
        Test test = testService.updateAsync(id, name);
        log.info("{}", test.toString());
    }

    @GetMapping("/error")
    public void throwError() {
        throw new UnsupportedOperationException();
    }

}
