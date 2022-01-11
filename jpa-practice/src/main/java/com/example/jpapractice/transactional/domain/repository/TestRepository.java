package com.example.jpapractice.transactional.domain.repository;

import com.example.jpapractice.transactional.domain.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {

    Optional<Test> findByName(String name);
}
