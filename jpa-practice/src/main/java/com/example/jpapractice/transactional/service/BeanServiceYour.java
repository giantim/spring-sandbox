package com.example.jpapractice.transactional.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class BeanServiceYour implements InitializingBean {

    private final CustomBean yourBean;

    public BeanServiceYour(CustomBean yourBean) {
        this.yourBean = yourBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(yourBean.getTitle());
    }
}
