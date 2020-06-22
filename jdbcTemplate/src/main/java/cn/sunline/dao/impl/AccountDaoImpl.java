package cn.sunline.dao.impl;

import cn.sunline.dao.IAccountDao;
import cn.sunline.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository
public class AccountDaoImpl implements IAccountDao {
    //jdbc模板类属性
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据id查找
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void saveAccount(Account account) {
        jdbcTemplate.update("insert into account  values(?,?,?)",
                account.getId(),account.getAccountNum(),account.getMoney());
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set accountnum=?,money=? where id=?",account.getAccountNum(),account.getMoney(),account.getId());
    }
}
