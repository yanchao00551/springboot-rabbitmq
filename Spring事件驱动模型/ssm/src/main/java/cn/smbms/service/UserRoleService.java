package cn.smbms.service;

import cn.smbms.pojo.User;

public interface UserRoleService {
	/**
	 * 编辑并给某个用户赋予多个角色
	 * @param user
	 * @param roleIds
	 */
	void editUserRole(User user, long[] roleIds);
}
