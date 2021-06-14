package cn.smbms.dao;
import cn.smbms.pojo.Permission;

import java.util.List;

public interface PermissionDao {
	Permission selectByPrimaryKey(Long id);

	List<Permission> selectPermissionList();

	void insertPermission(Permission permission);

	void updatePermission(Permission permission);

	void deletePermission(long id);
}
