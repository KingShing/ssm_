package com.kingshing.dao;

import com.kingshing.pojo.User;

public interface UserDao {
	
    /*
     * 检查用户名密码
     */
	public User checkNamePwd(Long id) ;
	
}
