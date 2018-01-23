package edu.chinasoft.mapper;

import edu.chinasoft.pojo.TUser;
import edu.chinasoft.pojo.TUserExample;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository("tUserMapper")
public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}