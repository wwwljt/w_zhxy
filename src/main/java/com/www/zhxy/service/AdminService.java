package com.www.zhxy.service;


import com.www.zhxy.entity.Admin;
import com.www.zhxy.entity.LoginForm;

import java.util.List;

/**
 * @author Www
 */
public interface AdminService {
	/**
	 * 用户登录
	 *
	 * @param loginForm
	 * @return
	 */
	Admin login(LoginForm loginForm);
	
	/**
	 * 根据is 查询 用户信息
	 *
	 * @param userId
	 * @return
	 */
	Admin getAdminById(Long userId);
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param adminName
	 * @return
	 */
	Integer getAdminCount(String adminName);
	
	/**
	 * 根据条件获取分页数据
	 * @param adminName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Admin> getAdminByOpr(String adminName, Integer pageNo, Integer pageSize);
}
