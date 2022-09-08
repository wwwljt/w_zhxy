package com.www.zhxy.controller;

import com.www.zhxy.entity.Admin;
import com.www.zhxy.service.AdminService;
import com.www.zhxy.util.Page;
import com.www.zhxy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/8  19:04  星期四
 * <p>
 */
@RestController
@RequestMapping("/sms/adminController")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getAllAdmin/{pageNo}/{pageSize}")
	public Result<Page<Admin>> getAdminAllBy(
			@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,
			String adminName
	) {
		// 根据条件获取总记录数
		Integer count = adminService.getAdminCount(adminName);
		
		List<Admin> adminList = adminService.getAdminByOpr(adminName, pageNo, pageSize);
		Page<Admin> adminPage=new Page<>(adminList,count,pageSize, pageNo);
		return Result.ok(adminPage);
	}
}
