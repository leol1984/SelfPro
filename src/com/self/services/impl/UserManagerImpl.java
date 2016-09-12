package com.self.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.self.beans.User;
import com.self.dao.BaseDao;
import com.self.forms.UserForm;
import com.self.redis.Redis;
import com.self.services.UserManager;

public class UserManagerImpl implements UserManager {

	private BaseDao dao;

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	@Override
	public void regUser(UserForm userForm) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		dao.saveObject(user);
	}

}

