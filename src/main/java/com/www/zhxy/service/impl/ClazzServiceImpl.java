package com.www.zhxy.service.impl;

import com.www.zhxy.dao.ClazzDao;
import com.www.zhxy.entity.Clazz;
import com.www.zhxy.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ClazzServiceImpl implements ClazzService {
	@Autowired
	private ClazzDao clazzDao;
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param clazz
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Clazz> getClazzByOpr(Clazz clazz, Integer pageNo, Integer pageSize) {
		pageNo = (pageNo - 1) * pageSize;
		return clazzDao.getClazzByOpr(clazz, pageNo, pageSize);
	}
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param clazz
	 * @return
	 */
	@Override
	public Integer getClazzCount(Clazz clazz) {
		return clazzDao.getClazzCount(clazz);
	}
	
	/**
	 * 获取所有 Clazz
	 *
	 * @return
	 */
	@Override
	public List<Clazz> getAllClazz() {
		return clazzDao.getAllClazz();
	}
}
