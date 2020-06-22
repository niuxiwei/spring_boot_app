package cn.sunline.dao.impl;

import cn.sunline.dao.IAccountDao;
import cn.sunline.entity.Account;
import cn.sunline.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//dao的实现类
@Repository
public class AccountDaoImpl implements IAccountDao {
    //dbutil的查询工具类
    @Autowired
    private QueryRunner runner;
    //连接的工具类
    @Autowired
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //修改账号
    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"update account set accountNum=?,money=? where id=?",account.getAccountNum(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //根据账号查询
    public Account findAccountByNum(String accountNum) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where accountNum = ? ",new BeanListHandler<Account>(Account.class),accountNum);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}