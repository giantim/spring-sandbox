package com.example.jpapractice.transactional.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class TestRepositoryTest {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void saveAndFindByName() {
        com.example.jpapractice.transactional.domain.entity.Test test = new com.example.jpapractice.transactional.domain.entity.Test("hi");
        testRepository.save(test);
        Optional<com.example.jpapractice.transactional.domain.entity.Test> optTest = testRepository.findByName(test.getName());
    }

}