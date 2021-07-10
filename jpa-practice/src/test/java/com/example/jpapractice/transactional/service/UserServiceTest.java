package com.example.jpapractice.transactional.service;

import com.example.jpapractice.transactional.domain.entity.Post;
import com.example.jpapractice.transactional.domain.entity.User;
import com.example.jpapractice.transactional.domain.repository.PostRepository;
import com.example.jpapractice.transactional.domain.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @DisplayName("요청 id 를 이용해 User 를 삭제한다.")
    @Test
    public void deleteUserTest() {
        // given
        User savedUser = userRepository.save(new User("user1"));
        Long userId = savedUser.getId();

        // when
        userService.deleteUserById(userId);

        // then
        User deletedUser = userRepository.findById(userId)
                .orElse(null);
        assertThat(deletedUser).isNull();
    }

    @DisplayName("요청 user id 가 잘못되었을 경우 예외를 반환한다")
    @Test
    public void deleteUserWithUnValidIdThrowException() {
        // given
        Long unValidUserId = -1L;

        // then
        assertThatThrownBy(() -> userService.deleteUserById(unValidUserId))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Transactional
    @DisplayName("외래키 제약사항에 포함된 user 를 삭제 시 예외를 반환한다")
    @Test
    public void deleteUserWithForeignKeyConstraints() {
        // given
        User savedUser = userRepository.save(new User("user1"));
        Post savedPost = postRepository.save(new Post("post1", savedUser));
        Long userId = savedUser.getId();

        // then
        assertThatThrownBy(() -> userService.deleteUserById(userId))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    private void tearDown() {
        postRepository.deleteAll();
        userRepository.deleteAll();
    }

}