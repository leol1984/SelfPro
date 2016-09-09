package com.self.services.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.self.beans.User;
import com.self.dao.BaseDao;
import com.self.dao.impl.HibernateSessionFactory;
import com.self.dao.impl.UserDao;
import com.self.forms.UserForm;
import com.self.services.UserManager;

public class UserManagerImpl implements UserManager {

	private BaseDao dao;

	private Session session;

	public UserManagerImpl() {
		dao = new UserDao();
	}

	@Override
	public void regUser(UserForm userForm) {

		session = HibernateSessionFactory.currentSession();
		dao.setSession(session);
		// 获取事务
		Transaction ts = session.beginTransaction();
		// 构造User对象
		User user = new User();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setGender(userForm.getGender());
		// 保存User对象
		dao.saveObject(user);
		// 提交事务
		ts.commit();
		// 关闭Session
		HibernateSessionFactory.closeSession();
	}

}
