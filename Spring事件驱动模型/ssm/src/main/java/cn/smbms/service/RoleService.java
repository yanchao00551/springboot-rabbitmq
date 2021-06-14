package cn.smbms.service;


import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import java.util.List;
import java.util.Set;

public interface RoleService {
	/**
	 * 通过 用户名 获取 他拥有的所有角色名
	 * @param name
	 * @return
	 */
	Set<String> listRoleName(String name);

	/**
	 * 通过 用户名 获取 他拥有的所有角色
	 * @param name
	 * @return
	 */
	List<Role> listRoleByName(String name);

	/**
	 * 通过 用户 获取 他拥有的所有角色
	 * @param user
	 * @return
	 */
	List<Role> listRoleByUser(User user);

	/**
	 * 获取所有角色类集
	 * @return
	 */
	List<Role> listRole();

	/**
	 * 新增一个角色
	 * @param role
	 */
	void addRole(Role role);

	/**
	 * 通过id获取角色
	 * @param id
	 * @return
	 */
	Role getRole(long id);

	/**
	 * 更新角色
	 * @param role
	 */
	void updateRole(Role role);

	/**
	 * 通过id删除角色
	 * @param id
	 */
	void deleteRoleByID(long id);
}
