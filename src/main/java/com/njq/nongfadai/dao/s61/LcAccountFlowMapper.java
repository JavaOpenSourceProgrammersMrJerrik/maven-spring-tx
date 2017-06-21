package com.njq.nongfadai.dao.s61;

import com.njq.nongfadai.common.IMapper;
import com.njq.nongfadai.dao.model.s61.LcAccountFlow;
import com.njq.nongfadai.dao.model.s61.LcAccountFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@IMapper
public interface LcAccountFlowMapper {
    int countByExample(LcAccountFlowExample example);

    int deleteByExample(LcAccountFlowExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(LcAccountFlow record);

    int insertSelective(LcAccountFlow record);

    List<LcAccountFlow> selectByExample(LcAccountFlowExample example);

    LcAccountFlow selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") LcAccountFlow record, @Param("example") LcAccountFlowExample example);

    int updateByExample(@Param("record") LcAccountFlow record, @Param("example") LcAccountFlowExample example);

    int updateByPrimaryKeySelective(LcAccountFlow record);

    int updateByPrimaryKey(LcAccountFlow record);
}