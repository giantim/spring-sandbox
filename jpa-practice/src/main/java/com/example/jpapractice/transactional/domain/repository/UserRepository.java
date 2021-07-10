package com.example.jpapractice.transactional.domain.repository;

import com.example.jpapractice.transactional.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
