package cn.smbms.service.impl;

import cn.smbms.dao.UserDao;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	@Override
	public List<User> listUser() {
		return userDao.selectUserList();
	}

	@Override
	public void addUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteUser(id);
	}

	@Override
	public User getUserByID(long id) {
		return userDao.getUserByID(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
