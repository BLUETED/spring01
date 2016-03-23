package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoMySQLImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoMySQLImplTest {
	private UserDao dao = new UserDaoMySQLImpl();
	@Test
	public void testFindUserByConditions() {
		dao.findUserByConditions(null,null,null, null, null, null, "false");
	}

}
