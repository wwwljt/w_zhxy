package com.www.zhxy.service;

import com.www.zhxy.entity.Grade;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/8  17:39  星期四
 * <p>
 */
public interface GradeService {
	/**
	 * 获取所有年级
	 *
	 * @return
	 */
	List<Grade> getGraderAll();
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param grade
	 * @return
	 */
	Integer getGraderCount(String grade);
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param grade
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Grade> getGraderByOpr(String grade, Integer pageNo, Integer pageSize);
}
