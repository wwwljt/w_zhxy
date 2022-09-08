package com.www.zhxy.dao;

import com.www.zhxy.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/8  17:43  星期四
 * <p>
 */
public interface GradeDao {
	/**
	 * 获取 所有 年级
	 *
	 * @return
	 */
	List<Grade> getGraderAll();
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param gradeName
	 * @return
	 */
	Integer getGraderCount(@Param("gradeName") String gradeName);
	
	/**
	 * 根据条件获取分页数据
	 * @param gradeName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Grade> getGraderByOpr(@Param("gradeName") String gradeName, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
