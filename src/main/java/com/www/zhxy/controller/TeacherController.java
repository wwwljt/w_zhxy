package com.www.zhxy.controller;

import com.www.zhxy.entity.Teacher;
import com.www.zhxy.service.TeacherService;
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
 * 创建时间: 2022/9/8  15:43  星期四
 * <p>
 */
@RestController
@RequestMapping("/sms/teacherController")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 分页条件查询
	 *
	 * @param pageNo
	 * @param pageSize
	 * @param teacher
	 * @return
	 */
	@GetMapping("/getTeachers/{pageNo}/{pageSize}")
	public Result<Page<Teacher>> getTeacher(
			@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,
			Teacher teacher
	) {
		System.out.println("teacher = " + teacher);
		// 获取总记录数
		Integer count = teacherService.getTeacherCount(teacher);
		// 获取条件分页数据
		List<Teacher> teachers = teacherService.getTeacherByOpr(teacher, pageNo, pageSize);
		Page<Teacher> teacherPage = new Page<>(teachers, count, pageSize, pageNo);
		return Result.ok(teacherPage);
	}
	
}
