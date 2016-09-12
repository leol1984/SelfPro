package com.self.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.self.dao.BaseDao;


public class UserDao extends HibernateDaoSupport implements BaseDao {

	@Override
	public void saveObject(Object obj) throws Exception {
        getSessionFactory().openSession().save(obj);
	}

}
