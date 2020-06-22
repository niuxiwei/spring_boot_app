package cn.sunline.config;

import cn.sunline.service.UserService;
import cn.sunline.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.sunline")
public class SpringConfig {

//    @Bean
//    public UserService publicCreateUserService(){
//        return new UserServiceImpl();
//    }
}
