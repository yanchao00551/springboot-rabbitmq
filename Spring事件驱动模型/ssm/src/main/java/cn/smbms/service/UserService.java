package cn.smbms.service;

import cn.smbms.pojo.User;
import java.util.List;

public interface UserService {
	/**
	 * 通过用户名获取用户
	 * @param name
	 * @return
	 */
	User getUserByName(String name);

	/**
	 * 获取所有用户类集
	 * @return
	 */
	List<User> listUser();

	/**
	 * 新增一个用户
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 通过用户id删除用户
	 * @param id
	 */
	void deleteUser(long id);

	/**
	 * 通过用户id获取用户
	 * @param id
	 * @return
	 */
	User getUserByID(long id);

	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(User user);
}
