package com.www.zhxy.service.impl;

import com.www.zhxy.dao.GradeDao;
import com.www.zhxy.entity.Grade;
import com.www.zhxy.service.GradeService;
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
 * 创建时间: 2022/9/8  17:42  星期四
 * <p>
 */
@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	private GradeDao gradeDao;
	
	
	/**
	 * 根据条件获取分页数据
	 *
	 * @param grade
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Grade> getGraderByOpr(String grade, Integer pageNo, Integer pageSize) {
		pageNo= (pageNo - 1) * pageSize;
		return gradeDao.getGraderByOpr(grade, pageNo, pageSize);
	}
	
	/**
	 * 根据条件获取总记录数
	 *
	 * @param grade
	 * @return
	 */
	@Override
	public Integer getGraderCount(String grade) {
		return gradeDao.getGraderCount(grade);
	}
	
	/**
	 * 获取所有年级
	 *
	 * @return
	 */
	@Override
	public List<Grade> getGraderAll() {
		return gradeDao.getGraderAll();
	}
}
