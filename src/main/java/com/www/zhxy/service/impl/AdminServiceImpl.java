package com.www.zhxy.service.impl;

import com.www.zhxy.dao.AdminDao;
import com.www.zhxy.entity.Admin;
import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.service.AdminService;
import com.www.zhxy.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Www
 */
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param adminName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Admin> getAdminByOpr(String adminName, Integer pageNo, Integer pageSize) {
		pageNo = (pageNo - 1) * pageSize;
		return adminDao.getAdminByOpr(adminName, pageNo, pageSize);
	}
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param adminName
	 * @return
	 */
	@Override
	public Integer getAdminCount(String adminName) {
		return adminDao.getAdminCount(adminName);
	}
	
	@Override
	public Admin login(LoginForm loginForm) {
		// 对密码进行加密
		loginForm.setPassword(MD5.encrypt(loginForm.getPassword()));
		return adminDao.login(loginForm);
	}
	
	@Override
	public Admin getAdminById(Long userId) {
		return adminDao.getAdminById(userId);
	}
}
