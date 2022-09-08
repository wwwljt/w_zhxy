package com.www.zhxy.service.impl;


import com.www.zhxy.dao.TeacherDao;
import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.entity.Teacher;
import com.www.zhxy.service.TeacherService;
import com.www.zhxy.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Www
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param teacher
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Teacher> getTeacherByOpr(Teacher teacher, Integer pageNo, Integer pageSize) {
		pageNo = (pageNo - 1) * pageSize;
		return teacherDao.getTeacherByOpr(teacher, pageNo, pageSize);
	}
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param teacher
	 * @return
	 */
	@Override
	public Integer getTeacherCount(Teacher teacher) {
		return teacherDao.getTeacherCount(teacher);
	}
	
	@Override
	public Teacher login(LoginForm loginForm) {
		// 对密码进行加密
		loginForm.setPassword(MD5.encrypt(loginForm.getPassword()));
		return teacherDao.login(loginForm);
	}
	
	/**
	 * 根据is 查询 用户信息
	 *
	 * @param userId
	 * @return
	 */
	@Override
	public Teacher getByTeacherById(Long userId) {
		return teacherDao.getByTeacherById(userId);
	}
}
