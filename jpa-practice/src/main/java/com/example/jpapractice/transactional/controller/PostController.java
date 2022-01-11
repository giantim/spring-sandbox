package com.example.jpapractice.transactional.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/post")
@RestController
public class PostController {

    @PostMapping("/rider-ids-by-long")
    public List<RiderLocation> byRiderIds(@RequestBody List<Long> riderIds) {
        List<RiderLocation> riderLocations = riderIds.stream()
                .map(riderId -> new RiderLocation(riderId, 1L, 3L))
                .collect(Collectors.toList());
        return riderLocations;
    }

    @GetMapping("/rider-ids-by-long")
    public void byRiderIdsGet() {
        System.out.println("hi");
    }

    @Getter
    @Setter
    private static class RiderLocation {
        private Long id;
        private Long latitude;
        private Long longitude;

        public RiderLocation(Long id, Long latitude, Long longitude) {
            this.id = id;
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
