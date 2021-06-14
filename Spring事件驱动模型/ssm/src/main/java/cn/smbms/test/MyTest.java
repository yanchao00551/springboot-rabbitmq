package cn.smbms.test;

import cn.smbms.service.RoleService;
import cn.smbms.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class MyTest {

	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@Test
	public void Test() {
		String name = "zhang3";
		Set<String> roles = roleService.listRoleName(name);
		System.out.println(roles);

	}
}
