package com.example.jpapractice.transactional.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class BeanServiceMy implements InitializingBean {

    private final CustomBean myBean;

    public BeanServiceMy(CustomBean myBean) {
        this.myBean = myBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(myBean.getTitle());
    }
}
