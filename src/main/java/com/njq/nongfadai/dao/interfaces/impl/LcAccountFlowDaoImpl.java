package com.njq.nongfadai.dao.interfaces.impl;

import java.util.List;

import junit.LcAccountFlowDaoImplTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.njq.nongfadai.dao.interfaces.ILcAccountFlowDao;
import com.njq.nongfadai.dao.model.s61.LcAccountFlow;
import com.njq.nongfadai.dao.s61.LcAccountFlowMapper;

@Component
@Transactional
public class LcAccountFlowDaoImpl implements ILcAccountFlowDao {
	private static Logger logger = LoggerFactory.getLogger(LcAccountFlowDaoImpl.class);

	@Autowired
	private LcAccountFlowMapper lcAccountFlowMapper;

	@Override
	public int addEntity(LcAccountFlow t) {
		logger.info("addEntity begin() " + TransactionAspectSupport.currentTransactionStatus());
		
		if(LcAccountFlowDaoImplTest.ROLLBACK_ON_STRING_DESC.equals(t.getDesc())){
			System.out.println("手动触发回滚");
			int i = 1/0;
		}
		return lcAccountFlowMapper.insert(t);
	}

	@Override
	public int deleteEntityById(Integer id) {
		logger.info("deleteEntityById begin()");
		return lcAccountFlowMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteEntity(LcAccountFlow t) {
		return 0;
	}

	@Override
	public int updateEntity(LcAccountFlow t) {
		logger.info("updateEntity begin() " + TransactionAspectSupport.currentTransactionStatus());
		int row =  lcAccountFlowMapper.updateByPrimaryKey(t);
		if(LcAccountFlowDaoImplTest.ROLLBACK_ON_STRING_DESC.equals(t.getDesc())){
			System.out.println("手动触发回滚");
			int i = 1/0;
		}
		return row;
	}

	@Override
	public LcAccountFlow findEntityById(Integer id) {
		return lcAccountFlowMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LcAccountFlow> findEntity(LcAccountFlow t) {
		return null;
	}

}
