package com.yll.ssm.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yll.ssm.dao.UserDao;
import com.yll.ssm.model.User;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		return this.getSqlSession().update("deleteByPrimaryKey", userId);
	}

	@Override
	public int insert(User record) {
		return this.getSqlSession().insert("insert", record);
	}

	@Override
	public int insertSelective(User record) {
		return this.getSqlSession().insert("insertSelective", record);
	}

	@Override
	public User selectByPrimaryKey(Integer userId) {
		return this.getSqlSession().selectOne("selectByPrimaryKey", userId);
	}

	@Override
	public User selectByName(String userName) {
		return this.getSqlSession().selectOne("selectByName", userName);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return this.getSqlSession().update("updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return this.getSqlSession().update("updateByPrimaryKey", record);
	}

}
