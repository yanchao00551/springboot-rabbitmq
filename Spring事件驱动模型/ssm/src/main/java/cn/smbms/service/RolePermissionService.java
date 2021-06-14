package cn.smbms.service;

import cn.smbms.pojo.Role;
public interface RolePermissionService {
	/**
	 * 更新某个角色的所有权限
	 * @param role
	 * @param permissionIds
	 */
	void updateRolePermission(Role role, long[] permissionIds);
}
