package com.www.zhxy.controller;

import com.www.zhxy.entity.Grade;
import com.www.zhxy.service.GradeService;
import com.www.zhxy.util.Page;
import com.www.zhxy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/8  17:36  星期四
 * <p>
 */
@RestController
@RequestMapping("/sms/gradeController")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	/**
	 * 获取所有年级
	 *
	 * @return
	 */
	@GetMapping("/getGrades")
	public Result<List<Grade>> getGraderAll() {
		List<Grade> grades = gradeService.getGraderAll();
		return Result.ok(grades);
	}
	
	/**
	 * 条件分页查询
	 *
	 * @return
	 */
	@GetMapping("/getGrades/{pageNo}/{pageSize}")
	public Result<Page<Grade>> getGradesByOpr(
			@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,
			String gradeName
	) {
		// 根据条件获取总记录数
		Integer count = gradeService.getGraderCount(gradeName);
		//根据条件获取分页数据
		List<Grade> grades = gradeService.getGraderByOpr(gradeName, pageNo, pageSize);
		Page<Grade> gradePage = new Page<>(grades, count, pageSize, pageNo);
		return Result.ok(gradePage);
	}
}
