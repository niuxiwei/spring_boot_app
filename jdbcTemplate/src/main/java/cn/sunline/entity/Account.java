package cn.sunline.entity;

import java.io.Serializable;

/**
 * 账户的实体类
 */
public class Account implements Serializable {
    //数据id
    private Integer id;
    //账号编码
    private String accountNum;
    //账号金额
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNum='" + accountNum + '\'' +
                ", money=" + money +
                '}';
    }
}
