package com.njq.nongfadai.service;

import com.njq.nongfadai.dao.model.s61.LcAccountFlow;

public interface ILcAccountFlowService {

	/**
	 * 无事务
	 * @param lcAccountFlow
	 * @return
	 */
	public int addLcAccountFlowWithNoTransaction(LcAccountFlow lcAccountFlow);
	
	/**
	 * 无事务,将代理对象传入。由this调用 改成代理对象调用
	 * @param lcAccountFlow
	 * @param lcAccountFlowService
	 * @return
	 */
	public int addLcAccountFlowWithNoTransaction(LcAccountFlow lcAccountFlow,ILcAccountFlowService lcAccountFlowService);
	
	/**
	 * 有事务
	 * @param lcAccountFlow
	 * @return
	 */
	public int addLcAccountFlowWithTransaction(LcAccountFlow lcAccountFlow);
	

	
	public int updateLcAccountFlow(LcAccountFlow lcAccountFlow);
}
