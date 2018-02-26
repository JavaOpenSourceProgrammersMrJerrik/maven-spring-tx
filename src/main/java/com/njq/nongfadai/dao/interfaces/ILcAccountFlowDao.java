package com.njq.nongfadai.dao.interfaces;

import com.njq.nongfadai.dao.BaseDao;
import com.njq.nongfadai.dao.model.s61.LcAccountFlow;

public interface ILcAccountFlowDao extends BaseDao<LcAccountFlow> {
	public int addEntityWithNoTransaction(LcAccountFlow lcAccountFlow);
}
