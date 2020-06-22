package cn.sunline.service.impl;

import cn.sunline.dao.IAccountDao;
import cn.sunline.entity.Account;
import cn.sunline.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//业务实现类
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String sourceAccount, String targetAccount, Integer money) {

        Account source = accountDao.findAccountByNum(sourceAccount);
        Account target = accountDao.findAccountByNum(targetAccount);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
        System.out.println("转账完毕");

    }
}
