package cn.smbms.service.impl;

import cn.smbms.dao.PermissionDao;
import cn.smbms.dao.RolePermissionDao;
import cn.smbms.pojo.Permission;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.RolePermission;
import cn.smbms.service.PermissionService;
import cn.smbms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	RoleService roleService;
	@Autowired
	RolePermissionDao rolePermissionDao;
	@Autowired
	PermissionDao permissionDao;

	@Override
	public Set<String> listPermissionName(String name) {
		Set<String> result = new HashSet<>();
		List<Role> roles = roleService.listRoleByName(name);
		List<RolePermission> rolePermissions = new ArrayList<>();
		for (Role role : roles) {
			List<RolePermission> rps = rolePermissionDao.selectListRolePermissionByRID(role.getId());
			rolePermissions.addAll(rps);
		}

		for (RolePermission rolePermission : rolePermissions) {
			Permission p = permissionDao.selectByPrimaryKey(rolePermission.getPid());
			result.add(p.getName());
		}

		return result;
	}

	@Override
	public List<Permission> getPermissionListByRole(Role role) {
		List<Permission> result = new ArrayList<>();

		List<RolePermission> rolePermissionList = rolePermissionDao.selectListRolePermissionByRID(role.getId());

		for (RolePermission rolePermission : rolePermissionList) {
			result.add(permissionDao.selectByPrimaryKey(rolePermission.getPid()));
		}
		return result;
	}

	@Override
	public List<Permission> getPermissionList() {
		return permissionDao.selectPermissionList();
	}

	@Override
	public void addPermission(Permission permission) {
		permissionDao.insertPermission(permission);
	}

	@Override
	public Permission getPermissionByID(long id) {
		return permissionDao.selectByPrimaryKey(id);
	}

	@Override
	public void updatePermission(Permission permission) {
		permissionDao.updatePermission(permission);
	}

	@Override
	public void deletePermission(long id) {
		permissionDao.deletePermission(id);
	}

	/**
	 * needInterceptor ??????????????????????????????
	 * ???????????????????????????????????? url,???????????????????????????????????????????????? ?????????????????????????????????
	 * ??????????????????????????????????????????????????????????????????????????????????????????????????????
	 */
	@Override
	public boolean needInterceptor(String requestURI) {
		List<Permission> ps = getPermissionList();
		for (Permission p : ps) {
			if (p.getUrl().equals(requestURI)){
				return true;
			}
		}
		return false;
	}

	/**
	 * ??????????????????????????????????????????????????????
	 */
	@Override
	public Set<String> listPermissionURLs(String userName) {
		Set<String> result = new HashSet<>();
		List<Role> roles = roleService.listRoleByName(userName);

		List<RolePermission> rolePermissions = new ArrayList<>();

		for (Role role : roles) {
			List<RolePermission> rps = rolePermissionDao.selectListRolePermissionByRID(role.getId());
			rolePermissions.addAll(rps);
		}
		for (RolePermission rolePermission : rolePermissions) {
			Permission p = permissionDao.selectByPrimaryKey(rolePermission.getPid());
			result.add(p.getUrl());
		}
		return result;
	}
}
