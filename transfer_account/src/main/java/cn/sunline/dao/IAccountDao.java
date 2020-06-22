package cn.sunline.dao;

import cn.sunline.entity.Account;
//dao的接口
public interface IAccountDao {
    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);
    /**
     * 根据编号查询账户
     */
    Account findAccountByNum(String accountNum);
}