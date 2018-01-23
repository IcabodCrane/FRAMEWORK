package edu.chinasoft.mapper;

import edu.chinasoft.pojo.TLog;
import edu.chinasoft.pojo.TLogExample;
import java.util.List;

public interface TLogMapper {
    int countByExample(TLogExample example);

    int deleteByExample(TLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TLog record);

    int insertSelective(TLog record);

    List<TLog> selectByExample(TLogExample example);

    TLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(TLog record);

    int updateByPrimaryKey(TLog record);
}