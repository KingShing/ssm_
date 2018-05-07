package com.kingshing.test;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kingshing.dao.UserDao;

public class TestApp {
		@Test
		public void testDao() throws Exception {
			String resource = "ClassPath:mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = factory.openSession();
			UserDao u = session.getMapper(com.kingshing.dao.UserDao.class);
			System.out.println(u);
		}
}
