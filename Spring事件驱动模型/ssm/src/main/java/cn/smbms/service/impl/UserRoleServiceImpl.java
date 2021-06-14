package cn.smbms.service.impl;

import cn.smbms.dao.UserRoleDao;
import cn.smbms.pojo.User;
import cn.smbms.pojo.UserRole;
import cn.smbms.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleDao userRoleDao;


	@Override
	public void editUserRole(User user, long[] roleIds) {
		// 删除当前用户所有的角色
		List<UserRole> userRoleList = userRoleDao.getUserRoleByUID(user.getId());
		for (UserRole userRole : userRoleList){
			userRoleDao.deleteByPrimaryKey(userRole.getId());
		}

		// 设置新的角色关系
		if (null != roleIds){
			for (long rid : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setRid(rid);
				userRole.setUid(user.getId());
				userRoleDao.insertUserRole(userRole);
			}
		}
	}
}
