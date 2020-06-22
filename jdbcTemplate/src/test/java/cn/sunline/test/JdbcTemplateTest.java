package cn.sunline.test;

import cn.sunline.dao.IAccountDao;
import cn.sunline.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试数据的查询和修改
 */
public class JdbcTemplateTest {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean(IAccountDao.class);
        Account account = accountDao.findAccountById(4);
        System.out.println(account);
        account.setMoney(200f);
        accountDao.updateAccount(account);
        System.out.println("账号更改成功");
    }
}
