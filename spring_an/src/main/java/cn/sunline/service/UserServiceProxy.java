package cn.sunline.service;

public class UserServiceProxy implements  UserService {
    //被代理类实现接口
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }
    //覆写的方法
    @Override
    public void saveUser() {
        System.out.println("原始功能执行之前的逻辑代码");
        userService.saveUser();
        System.out.println("原始功能执行之后的逻辑代码");
    }

    @Override
    public void deleteById(Integer id) {

    }
}
