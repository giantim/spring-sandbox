package com.example.jpapractice.transactional.adapter.controller;

import com.example.jpapractice.transactional.adapter.persistence.ErrorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class RepositoryController {

    private final ErrorRepository errorRepository;

    public RepositoryController(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    @GetMapping("/error")
    public void error() {
        errorRepository.error();
    }
}
