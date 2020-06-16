package cn.sunline.spring_boot_app.controller;

import cn.sunline.spring_boot_app.domain.User;
import cn.sunline.spring_boot_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    /**
     * 采用构造器的注入方式
     * 好处：1、不能修改；2、提早进行初始化，相对字段型的注入比较好点
     */
    private final UserRepository userRepository;

    /**
     * 参数通过SPring框架传递
     * @Autowired可加可不加，为了阅读方便加上
     * @param userRepository
     */
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.printf("用户对象：%s 保存成功！\n",user);
        }
        return user;
    }

}
