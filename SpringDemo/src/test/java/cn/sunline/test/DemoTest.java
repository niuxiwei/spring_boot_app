package cn.sunline.test;

import cn.sunline.service.UserService;
import cn.sunline.service.impl.UserServiceImpl;
import cn.sunline.spring.SpringContext;
import cn.sunline.spring.impl.XmlSpringContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //初始化容器（读取配置文件 构建工厂）
        SpringContext context =
                new XmlSpringContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        userService.deleteById(1);
        System.out.println(userService.getUserDao());
//        System.out.println(context.getBean("user"));
//        UserService service = (UserService) context.getBean("userService");
//        System.out.println(context.getBean("userService"));
//        System.out.println(context.getBean("userService2"));
//        service.saveUser();
    }
}
