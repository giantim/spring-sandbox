package com.example.jpapractice.transactional.config;

import com.example.jpapractice.transactional.service.CustomBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanNameConfiguration {

    @Bean
    public CustomBean myBean() {
        return new CustomBean("my");
    }

    @Bean
    public CustomBean yourBean() {
        return new CustomBean("your");
    }

}
