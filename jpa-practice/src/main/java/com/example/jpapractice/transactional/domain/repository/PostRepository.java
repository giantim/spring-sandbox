package com.example.jpapractice.transactional.domain.repository;

import com.example.jpapractice.transactional.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
