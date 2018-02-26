package com.njq.nongfadai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.njq.nongfadai.dao.model.s61.LcAccountFlow;
import com.njq.nongfadai.dao.s61.LcAccountFlowMapper;

@Component
@Transactional
public class LcTransactionService {
	@Autowired
	private LcAccountFlowMapper lcAccountFlowMapper;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int requiresNew(LcAccountFlow lcAccountFlow) {
		System.out.println("事务方法 requiresNew begin()");
		lcAccountFlowMapper.insertSelective(lcAccountFlow);
		return lcAccountFlow.getFid();
	}
}
