package com.njq.nongfadai.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.njq.nongfadai.dao.interfaces.ILcAccountFlowDao;
import com.njq.nongfadai.dao.model.s61.LcAccountFlow;
import com.njq.nongfadai.service.ITxService;

@Component
@Transactional
public class TxServiceImpl implements ITxService {
	@Autowired
	private ILcAccountFlowDao lcAccountFlowDao;

	@Autowired
	private PlatformTransactionManager txManager;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Override
	public void doTransaction() {
		System.err.println("**************** start method A ****************");
		lcAccountFlowDao.addEntity(getLcAccountFlow("testTransaction1"));
		System.err.println("**************** start method B ****************");
		lcAccountFlowDao.addEntityWithNoTransaction(getLcAccountFlow("testTransaction32"));
		System.err.println("**************** over method ****************");
	}

	private LcAccountFlow getLcAccountFlow(String desc) {
		LcAccountFlow lcAccountFlow = new LcAccountFlow();
		lcAccountFlow.setAccountId(1);
		lcAccountFlow.setToAccountId(1);
		lcAccountFlow.setBussTypeId(4444);
		lcAccountFlow.setCreateTime(new Date());
		lcAccountFlow.setCheckStatus("YDZ");
		lcAccountFlow.setIncome(BigDecimal.ZERO);
		lcAccountFlow.setExpenses(BigDecimal.ZERO);
		lcAccountFlow.setBalance(BigDecimal.ZERO);
		lcAccountFlow.setDesc(desc);
		return lcAccountFlow;
	}
}
