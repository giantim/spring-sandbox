package com.example.jpapractice.woowa.service;

import com.example.jpapractice.woowa.controller.TestController;
import com.example.jpapractice.woowa.domain.WeatherExtraFee;
import com.example.jpapractice.woowa.repository.WeatherExtraFeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestService {

    private final WeatherExtraFeeRepository weatherExtraFeeRepository;

    public void save(TestController.Request request) {
        weatherExtraFeeRepository.save(new WeatherExtraFee(request));
    }

    public List<WeatherExtraFee> findAll() {
         return weatherExtraFeeRepository.findAll();
    }

}
