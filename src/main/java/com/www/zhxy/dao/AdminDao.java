package com.www.zhxy.dao;

import com.www.zhxy.entity.Admin;
import com.www.zhxy.entity.LoginForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/7  19:00  星期三
 * <p>
 */
public interface AdminDao {
	/**
	 * 登录
	 *
	 * @param loginForm
	 * @return
	 */
	Admin login(@Param("loginForm") LoginForm loginForm);
	
	/**
	 * 根据id 查询
	 *
	 * @param userId
	 * @return
	 */
	Admin getAdminById(@Param("userId") Long userId);
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param adminName
	 * @return
	 */
	Integer getAdminCount(@Param("adminName") String adminName);
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param adminName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Admin> getAdminByOpr(@Param("adminName") String adminName, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
