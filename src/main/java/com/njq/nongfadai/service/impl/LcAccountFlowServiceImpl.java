package com.njq.nongfadai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.njq.nongfadai.dao.model.s61.LcAccountFlow;
import com.njq.nongfadai.dao.s61.LcAccountFlowMapper;
import com.njq.nongfadai.service.ILcAccountFlowService;

@Component
public class LcAccountFlowServiceImpl implements ILcAccountFlowService {
	
	@Autowired
	private LcAccountFlowMapper lcAccountFlowMapper;
	
	@Override
	@Transactional
	public int addLcAccountFlowWithTransaction(LcAccountFlow lcAccountFlow) {
		System.out.println("事务方法 addLcAccountFlowWithTransaction begin()");
		lcAccountFlowMapper.insertSelective(lcAccountFlow);
		
		LcAccountFlow _lcAccountFlow = lcAccountFlowMapper.selectByPrimaryKey(lcAccountFlow.getFid());
		_lcAccountFlow.setDesc("updateLcAccountFlowById");
		
		updateLcAccountFlow(_lcAccountFlow);
		
		System.out.println("事务方法 addLcAccountFlowWithTransaction end()");
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

}
