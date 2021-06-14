package com.power.modules.app.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.power.common.exception.RRException;
import com.power.modules.app.dao.UserDao;
import com.power.modules.app.entity.UserEntity;
import com.power.modules.app.form.LoginForm;
import com.power.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.power.common.validator.Assert;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}


}
