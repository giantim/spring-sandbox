package com.example.jpapractice.transactional.adapter.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class ErrorRepository {

    public void error() {
        throw new IllegalArgumentException("repository 에러 발생시 advice를 확인하기 위한 에러입니다.");
    }
}
