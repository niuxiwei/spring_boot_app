package cn.sunline.dao.impl;

import cn.sunline.dao.UserDao;
import org.springframework.stereotype.Repository;

public class UserDaoImpl implements UserDao {

    public void saveUser() {
        System.out.println("执行dao的保存方法");
    }
}