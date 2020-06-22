package cn.sunline.service.impl;


import cn.sunline.dao.UserDao;
import cn.sunline.service.UserService;
import org.springframework.stereotype.Service;

//实现类的代码
//@Service("us")
public class UserServiceImpl implements UserService {

    //持久层的dao属性
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //实现接口的方法
    public void deleteById(Integer id) {

        System.out.println("删除的方法执行");
    }

    public void saveUser() {
        System.out.println("service的save方法执行了");
    }
}
