package com.njq.nongfadai.dao.model.s61;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Jerrik
 * @date 2017-6-21
 */
public class FreezeAccountFlow {
    /** 自增ID */
    private Integer fid;

    /** 资金账号ID,参考t_lc_account.fid */
    private Integer accountId;

    /** 交易类型ID,参考T5122.F01 */
    private Integer bussTypeId;

    /** 账户类型,TZDJZZH:平台投资冻结子账号,HKDJZZH:平台还款冻结子帐户,YXZZH:平台营销子帐户 */
    private String type;

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

    /** 是否更新t_lc_account帐户余额 */
    private String isUpdateAccountBalance;

    /** 更新帐户余额时间 */
    private Date updateAccountBalanceTime;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getIsUpdateAccountBalance() {
        return isUpdateAccountBalance;
    }

    public void setIsUpdateAccountBalance(String isUpdateAccountBalance) {
        this.isUpdateAccountBalance = isUpdateAccountBalance == null ? null : isUpdateAccountBalance.trim();
    }

    public Date getUpdateAccountBalanceTime() {
        return updateAccountBalanceTime;
    }

    public void setUpdateAccountBalanceTime(Date updateAccountBalanceTime) {
        this.updateAccountBalanceTime = updateAccountBalanceTime;
    }
}