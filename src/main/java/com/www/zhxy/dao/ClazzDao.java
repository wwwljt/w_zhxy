package com.www.zhxy.dao;

import com.www.zhxy.entity.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/8  11:38  星期四
 * <p>
 */
public interface ClazzDao {
	/**
	 * 获取所有 Clazz
	 *
	 * @return
	 */
	List<Clazz> getAllClazz();
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param clazz
	 * @return
	 */
	Integer getClazzCount(@Param("clazz") Clazz clazz);
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param clazz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Clazz> getClazzByOpr(@Param("clazz") Clazz clazz, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
