package com.njq.nongfadai.dao.model.s61;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Jerrik
 * @date 2017-6-21
 */
public class LcAccountFlow {
    /** 自增ID */
    private Integer fid;

    /** 资金账号ID,参考t_lc_account.fid */
    private Integer accountId;

    /** 交易类型ID,参考T5122.F01 */
    private Integer bussTypeId;

    /** 对方账户ID,参考t_lc_account.fid */
    private Integer toAccountId;

    /** 创建时间 */
    private Date createTime;

    /** 收入 */
    private BigDecimal income;

    /** 支出 */
    private BigDecimal expenses;

    /** 余额 */
    private BigDecimal balance;

    /** 备注 */
    private String desc;

    /** 对账状态,WDZ:未对账;YDZ:已对账; */
    private String checkStatus;

    /** 对账时间 */
    private Date checkTime;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getBussTypeId() {
        return bussTypeId;
    }

    public void setBussTypeId(Integer bussTypeId) {
        this.bussTypeId = bussTypeId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public void setExpenses(BigDecimal expenses) {
        this.expenses = expenses;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}