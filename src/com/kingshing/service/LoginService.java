package com.kingshing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshing.dao.UserDao;
import com.kingshing.pojo.User;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public User checkLogin(Long id) {
		return userDao.checkNamePwd(id);
	}
}
