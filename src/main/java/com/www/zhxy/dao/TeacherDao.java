package com.www.zhxy.dao;

import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/7  19:14  星期三
 * <p>
 */
public interface TeacherDao {
	/**
	 * 教师登录
	 *
	 * @param loginForm
	 * @return
	 */
	Teacher login(@Param("loginForm") LoginForm loginForm);
	
	/**
	 * 根据is 查询 用户信息
	 *
	 * @param userId
	 * @return
	 */
	Teacher getByTeacherById(@Param("userId") Long userId);
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param teacher
	 * @return
	 */
	Integer getTeacherCount(@Param("teacher") Teacher teacher);
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param teacher
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Teacher> getTeacherByOpr(@Param("teacher") Teacher teacher, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
