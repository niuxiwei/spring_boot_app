package cn.sunline.test;

import cn.sunline.controller.UserController;
import cn.sunline.dao.UserDao;
import cn.sunline.service.UserService;
import cn.sunline.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnDemoTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext_an.xml");
        UserController controller = (UserController) context.getBean("userController");
        UserService service = (UserServiceImpl) context.getBean("us");
        UserDao dao = (UserDao) context.getBean("userDaoImpl");
        System.out.println(controller);
        System.out.println(service);
        System.out.println(dao);

        dao.saveUser();
    }
}

