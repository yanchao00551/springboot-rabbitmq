package cn.smbms.dao;

import cn.smbms.pojo.Role;
import java.util.List;

public interface RoleDao {
	Role selectByPrimaryKey(Long id);

	List<Role> selectRoleList();

	void insertRole(Role role);

	void updateRole(Role role);

	void deleteRoleByID(long id);
}
