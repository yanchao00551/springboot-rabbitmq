package cn.smbms.dao;

import cn.smbms.pojo.UserRole;

import java.util.List;

public interface UserRoleDao {
	List<UserRole> getUserRoleByUID(Long uid);

	void deleteByPrimaryKey(Long id);

	void insertUserRole(UserRole userRole);
}
