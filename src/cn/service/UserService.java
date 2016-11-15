package cn.service;

import cn.dao.UserDao;
import cn.dao.UserDaoImple;
import cn.vo.User;

public class UserService {

	public User login(User user) {
		UserDao dao = new UserDaoImple();
		return dao.login(user);
	}
	
	
}
