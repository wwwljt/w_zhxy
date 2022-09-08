package com.www.zhxy.service;


import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.entity.Teacher;

import java.util.List;

/**
 * @author Www
 */
public interface TeacherService {
	
	/**
	 * 教师登录
	 *
	 * @param loginForm
	 * @return
	 */
	Teacher login(LoginForm loginForm);
	
	/**
	 * 根据is 查询 用户信息
	 *
	 * @param userId
	 * @return
	 */
	Teacher getByTeacherById(Long userId);
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param teacher
	 * @return
	 */
	Integer getTeacherCount(Teacher teacher);
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param teacher
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Teacher> getTeacherByOpr(Teacher teacher, Integer pageNo, Integer pageSize);
}
