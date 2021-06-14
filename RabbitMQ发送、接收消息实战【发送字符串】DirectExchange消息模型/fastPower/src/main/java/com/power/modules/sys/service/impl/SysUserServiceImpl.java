package com.power.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.power.modules.sys.dao.SysUserDao;
import com.power.modules.sys.entity.SysUserEntity;
import com.power.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;


/**
 * 系统用户
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	@Override
	public SysUserEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}
}
