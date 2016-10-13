package com.yll.ssm.dao;

import com.yll.ssm.model.User;

public interface UserDao {
	int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    
    User selectByName(String userName);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
