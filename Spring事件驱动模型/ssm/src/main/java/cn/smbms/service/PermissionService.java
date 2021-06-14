package cn.smbms.service;


import cn.smbms.pojo.Permission;
import cn.smbms.pojo.Role;
import java.util.List;
import java.util.Set;

public interface PermissionService {
	/**
	 * 通过角色名称获取该角色的所有权限名
	 * @param name
	 * @return
	 */
	Set<String> listPermissionName(String name);

	/**
	 * 通过角色获取该角色所有权限类集
	 * @param role
	 * @return
	 */
	List<Permission> getPermissionListByRole(Role role);

	/**
	 * 获取所有权限类集
	 * @return
	 */
	List<Permission> getPermissionList();

	/**
	 * 新增权限
	 * @param permission
	 */
	void addPermission(Permission permission);

	/**
	 * 根据id获取权限
	 * @param id
	 * @return
	 */
	Permission getPermissionByID(long id);

	/**
	 * 更新权限
	 * @param permission
	 */
	void updatePermission(Permission permission);

	/**
	 * 删除权限
	 * @param id
	 */
	void deletePermission(long id);

	/**
	 * needInterceptor 表示是否要进行拦截，
	 * 判断依据是如果访问的某个 url,在权限系统里存在，就要进行拦截。 如果不存在，就放行了。
	 * 也可以用这种，即，访问的地址如果不存在于权限系统中，就提示没有拦截。
	 * @param requestURI
	 * @return
	 */
	boolean needInterceptor(String requestURI);

	/**
	 * 用来获取某个用户所拥有的权限地址集合
	 * @param userName
	 * @return
	 */
	Set<String> listPermissionURLs(String userName);
}
