package cn.sunline.test;

import cn.sunline.config.SpringConfig;
import cn.sunline.proxy.DynamicProxy;
import cn.sunline.service.UserService;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();
        //获取接口实例
        UserService service = context.getBean(UserService.class);
//        创建实例的代理
//        UserServiceProxy proxy = new UserServiceProxy(service);
        //动态创建实例的代理
        UserService proxy = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
                new Class[]{UserService.class}, new DynamicProxy(service));
        //proxy执行方法
        proxy.saveUser();

    }
}
