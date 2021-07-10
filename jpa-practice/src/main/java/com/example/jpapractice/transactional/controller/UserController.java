package com.example.jpapractice.transactional.controller;

import com.example.jpapractice.transactional.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
