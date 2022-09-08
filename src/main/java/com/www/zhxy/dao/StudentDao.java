package com.www.zhxy.dao;

import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/7  19:09  星期三
 * <p>
 */
public interface StudentDao {
	/**
	 * 学生登录
	 *
	 * @param loginForm
	 * @return
	 */
	Student login(@Param("loginForm") LoginForm loginForm);
	
	/**
	 * 根据is 查询 用户信息
	 *
	 * @param userId
	 * @return
	 */
	Student getStudentById(@Param("userId") Long userId);
	
	/**
	 * 条件查询
	 *
	 * @param student
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Student> getStudentOpr(@Param("student") Student student, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
	
	/**
	 * 获取总记录数
	 *
	 * @param student
	 * @return
	 */
	int getStudentByOprCount(@Param("student") Student student);
	
	/**
	 * 根据 id批量删除
	 *
	 * @param ids
	 * @return
	 */
	Integer delStudentById(@Param("ids") List<Integer> ids);
}
