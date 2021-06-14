package cn.smbms.service.impl;

import cn.smbms.dao.RolePermissionDao;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.RolePermission;
import cn.smbms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	RolePermissionDao rolePermissionDao;

	@Override
	public void updateRolePermission(Role role, long[] permissionIds) {
		// 删除当前角色所有的权限
		List<RolePermission> rolePermissionList = rolePermissionDao.selectListRolePermissionByRID(role.getId());
		for (RolePermission rolePermission : rolePermissionList){
			rolePermissionDao.deleteByPrimaryKey(rolePermission.getId());
		}

		// 设置新的权限关系
		if (null != permissionIds){
			for (long pid : permissionIds) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setPid(pid);
				rolePermission.setRid(role.getId());
				rolePermissionDao.insertRolePermission(rolePermission);
			}
		}
	}
}
