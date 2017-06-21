package com.njq.nongfadai.dao.s61;

import com.njq.nongfadai.common.IMapper;
import com.njq.nongfadai.dao.model.s61.FreezeAccountFlow;
import com.njq.nongfadai.dao.model.s61.FreezeAccountFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@IMapper
public interface FreezeAccountFlowMapper {
    int countByExample(FreezeAccountFlowExample example);

    int deleteByExample(FreezeAccountFlowExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(FreezeAccountFlow record);

    int insertSelective(FreezeAccountFlow record);

    List<FreezeAccountFlow> selectByExample(FreezeAccountFlowExample example);

    FreezeAccountFlow selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") FreezeAccountFlow record, @Param("example") FreezeAccountFlowExample example);

    int updateByExample(@Param("record") FreezeAccountFlow record, @Param("example") FreezeAccountFlowExample example);

    int updateByPrimaryKeySelective(FreezeAccountFlow record);

    int updateByPrimaryKey(FreezeAccountFlow record);
}