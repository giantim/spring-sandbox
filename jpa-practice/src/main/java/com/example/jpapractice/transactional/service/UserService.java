package com.example.jpapractice.transactional.service;

import com.example.jpapractice.transactional.domain.entity.User;
import com.example.jpapractice.transactional.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

//    @Transactional
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        try {
            userRepository.delete(user);
        } catch (DataIntegrityViolationException exception) {
            throw new IllegalArgumentException();
        }
    }

}
