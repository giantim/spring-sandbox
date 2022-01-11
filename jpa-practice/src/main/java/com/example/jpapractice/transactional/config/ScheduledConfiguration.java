package com.example.jpapractice.transactional.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class ScheduledConfiguration {

    @Configuration
    @Profile("local")
    public static class LocalConfig implements InitializingBean {

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("local bean");
        }
    }

    @Configuration
    @Profile("dev")
    public static class DevConfig implements InitializingBean {

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("dev bean");
        }
    }

    @Configuration
    @Profile({"!local & !dev"})
    public static class BetaConfig implements InitializingBean {

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("beta bean");
        }
    }

}
