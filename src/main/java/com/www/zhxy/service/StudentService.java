package com.www.zhxy.service;


import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.entity.Student;

import java.util.List;

/**
 * @author Www
 */
public interface StudentService {
	
	/**
	 * 学生登录
	 *
	 * @param loginForm
	 * @return
	 */
	Student login(LoginForm loginForm);
	
	/**
	 * 根据is 查询 用户信息
	 *
	 * @param userId
	 * @return
	 */
	Student getStudentById(Long userId);
	
	/**
	 * 分页查询
	 *
	 * @param student
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Student> getStudentByOpr(Student student, Integer pageNo, Integer pageSize);
	
	/**
	 * 获取总记录数
	 *
	 * @param student
	 * @return
	 */
	int getStudentByOprCount(Student student);
	
	/**
	 * 根据id批量删除
	 *
	 * @param ids
	 * @return
	 */
	Integer delStudentById(List<Integer> ids);
}
