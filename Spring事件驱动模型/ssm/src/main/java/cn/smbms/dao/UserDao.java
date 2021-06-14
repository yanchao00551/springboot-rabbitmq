package cn.smbms.dao;
import cn.smbms.pojo.User;

import java.util.List;

public interface UserDao {
	User getUserByName(String name);

	List<User> selectUserList();

	void insertUser(User user);

	void deleteUser(long id);

	User getUserByID(long id);

	void updateUser(User user);
}
