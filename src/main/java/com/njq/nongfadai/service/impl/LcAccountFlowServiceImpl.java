package com.njq.nongfadai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.njq.nongfadai.dao.model.s61.LcAccountFlow;
import com.njq.nongfadai.dao.s61.LcAccountFlowMapper;
import com.njq.nongfadai.service.ILcAccountFlowService;

@Component
@Transactional
public class LcAccountFlowServiceImpl implements ILcAccountFlowService {
	
	@Autowired
	private LcAccountFlowMapper lcAccountFlowMapper;
	
	@Autowired
	private LcTransactionService transactionService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int addLcAccountFlowWithTransaction(LcAccountFlow lcAccountFlow) {
		System.out.println("事务方法 addLcAccountFlowWithTransaction begin()");
		LcAccountFlow _lcAccountFlow = lcAccountFlowMapper.selectByPrimaryKey(189);
		_lcAccountFlow.setFid(null);
		_lcAccountFlow.setDesc("测试事务方法1");
		
		//int fid = transactionService.requiresNew(lcAccountFlow);
		//updateLcAccountFlow(_lcAccountFlow);
		
		LcAccountFlow result = lcAccountFlowMapper.selectByPrimaryKey(200);
		System.out.println("result: " + result);
		return 0;
	}
	
	//this调用
	@Override
	public int addLcAccountFlowWithNoTransaction(LcAccountFlow lcAccountFlow) {
		System.out.println("非事务方法 addLcAccountFlowWithNoTransaction begin()");
		lcAccountFlowMapper.insertSelective(lcAccountFlow);
		
		LcAccountFlow _lcAccountFlow = lcAccountFlowMapper.selectByPrimaryKey(lcAccountFlow.getFid());
		_lcAccountFlow.setDesc("updateLcAccountFlowById");
		
		// ******************* this调用 *******************
		updateLcAccountFlow(_lcAccountFlow);
		
		System.out.println("非事务方法 addLcAccountFlowWithNoTransaction end()");
		return 0;
	}
	
	//传入代理对象
	@Override
	public int addLcAccountFlowWithNoTransaction(LcAccountFlow lcAccountFlow,ILcAccountFlowService lcAccountFlowService) {
		System.out.println("非事务方法 addLcAccountFlowWithNoTransaction begin()");
		lcAccountFlowMapper.insertSelective(lcAccountFlow);
		
		LcAccountFlow _lcAccountFlow = lcAccountFlowMapper.selectByPrimaryKey(lcAccountFlow.getFid());
		_lcAccountFlow.setDesc("updateLcAccountFlowById");
		
		// ******************* 代理对象调用 *******************
		lcAccountFlowService.updateLcAccountFlow(_lcAccountFlow);
		
		System.out.println("非事务方法 addLcAccountFlowWithNoTransaction end()");
		return 0;
	}

	@Override
	@Transactional
	public int updateLcAccountFlow(LcAccountFlow lcAccountFlow) {
		int row = lcAccountFlowMapper.updateByPrimaryKey(lcAccountFlow);
		int i = 1/0;
		return row;
	}

	@Override
	@Cacheable(value = { "lcAccount_load" })
	public Object loadCache() {
		System.out.println("load 一次");
		return "hello_world";
	}

}
