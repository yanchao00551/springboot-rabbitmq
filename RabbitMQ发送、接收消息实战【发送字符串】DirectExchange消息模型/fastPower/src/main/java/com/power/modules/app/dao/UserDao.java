package com.power.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.power.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 前台用户表
 */
@Mapper
@Component
public interface UserDao extends BaseMapper<UserEntity> {
	
}
