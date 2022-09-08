package com.www.zhxy.service.impl;


import com.www.zhxy.dao.StudentDao;
import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.entity.Student;
import com.www.zhxy.service.StudentService;
import com.www.zhxy.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Www
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	/**
	 * 根据id批量删除
	 *
	 * @param ids
	 * @return
	 */
	@Override
	public Integer delStudentById(List<Integer> ids) {
		return studentDao.delStudentById(ids);
	}
	
	/**
	 * 获取总记录数
	 *
	 * @param student
	 * @return
	 */
	@Override
	public int getStudentByOprCount(Student student) {
		return studentDao.getStudentByOprCount(student);
	}
	
	/**
	 * 学生登录
	 *
	 * @param loginForm
	 * @return
	 */
	@Override
	public Student login(LoginForm loginForm) {
		// 对密码进行加密
		loginForm.setPassword(MD5.encrypt(loginForm.getPassword()));
		return studentDao.login(loginForm);
	}
	
	/**
	 * 分页带条件查询
	 *
	 * @param student
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Student> getStudentByOpr(Student student, Integer pageNo, Integer pageSize) {
		pageNo = (pageNo - 1) * pageSize;
		return studentDao.getStudentOpr(student, pageNo, pageSize);
	}
	
	/**
	 * 根据is 查询 用户信息
	 *
	 * @param userId
	 * @return
	 */
	@Override
	public Student getStudentById(Long userId) {
		return studentDao.getStudentById(userId);
	}
	
}
