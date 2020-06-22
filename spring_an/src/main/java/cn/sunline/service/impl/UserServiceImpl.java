package cn.sunline.service.impl;

import cn.sunline.service.UserService;
import org.springframework.stereotype.Service;

//实现类的代码
@Service
public class UserServiceImpl implements UserService {

    //实现接口的方法
    public void deleteById(Integer id) {

        System.out.println("删除的方法执行");
    }

    public void saveUser() {
        System.out.println("执行service中的保存逻辑");
    }
}
