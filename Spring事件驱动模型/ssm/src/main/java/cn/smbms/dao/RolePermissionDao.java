package cn.smbms.dao;

import cn.smbms.pojo.RolePermission;

import java.util.List;

public interface RolePermissionDao {
	List<RolePermission> selectListRolePermissionByRID(Long rid);

	void deleteByPrimaryKey(Long id);

	void insertRolePermission(RolePermission rolePermission);
}
