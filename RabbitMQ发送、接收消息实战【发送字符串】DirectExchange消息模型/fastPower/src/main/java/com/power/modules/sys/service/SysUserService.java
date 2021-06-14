package com.power.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.power.modules.sys.entity.SysUserEntity;


/**
 * 系统用户
 */
public interface SysUserService extends IService<SysUserEntity> {
	SysUserEntity queryByUserName(String username);
}
