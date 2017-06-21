package com.njq.nongfadai.dao.interfaces.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.njq.nongfadai.dao.interfaces.IFreezeAccountFlowDao;
import com.njq.nongfadai.dao.model.s61.FreezeAccountFlow;
import com.njq.nongfadai.dao.s61.FreezeAccountFlowMapper;

@Component
@Transactional
public class FreezeAccountFlowDaoImpl implements IFreezeAccountFlowDao {
	
	private static Logger logger = LoggerFactory.getLogger(FreezeAccountFlowDaoImpl.class);
	
	@Autowired
	private FreezeAccountFlowMapper freezeAccountFlowMapper;

	@Override
	public int addEntity(FreezeAccountFlow t) {
		logger.info("addEntity begin()");
		return freezeAccountFlowMapper.insert(t);
	}

	@Override
	public int deleteEntityById(Integer id) {
		logger.info("deleteEntityById begin()");
		return freezeAccountFlowMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteEntity(FreezeAccountFlow t) {
		return 0;
	}

	@Override
	public int updateEntity(FreezeAccountFlow t) {
		return 0;
	}

	@Override
	public FreezeAccountFlow findEntityById(Integer id) {
		return null;
	}

	@Override
	public List<FreezeAccountFlow> findEntity(FreezeAccountFlow t) {
		return null;
	}

}
