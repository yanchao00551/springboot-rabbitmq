package com.power.modules.app.controller;


import com.power.common.utils.R;
import com.power.common.validator.ValidatorUtils;
import com.power.modules.app.annotation.Login;
import com.power.modules.app.annotation.LoginUser;
import com.power.modules.app.entity.UserEntity;
import com.power.modules.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/app")
@Api(tags="用户中心管理")
public class AppMemberController {
	@Autowired
	UserService userService;

    @Login
    @GetMapping("userInfo")
    @ApiOperation("获取用户信息")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }


    @Login
    @PostMapping("setUserInfo")
    @ApiOperation("设置个人信息")
    public R setUserInfo(@RequestAttribute("userId") Integer userId,@LoginUser UserEntity user,@RequestBody UserEntity form) {
        ValidatorUtils.validateEntity(form);
    	user.setUserHeadimg(form.getUserHeadimg());
    	user.setNickName(form.getNickName());
    	user.setSex(form.getSex());
    	user.setUserId((long)userId);
    	userService.updateById(user);
    	return R.ok();
    }
}
