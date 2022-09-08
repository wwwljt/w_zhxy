package com.www.zhxy.controller;

import com.www.zhxy.entity.Student;
import com.www.zhxy.service.StudentService;
import com.www.zhxy.util.Page;
import com.www.zhxy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生控制器
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/8  11:09  星期四
 * <p>
 */
@RestController
@RequestMapping("/sms/studentController")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@DeleteMapping("/delStudentById")
	public Result delStudentById(
			@RequestBody List<Integer> ids
	) {
		// 批量删除
		Integer result = studentService.delStudentById(ids);
		System.out.println("result = " + result);
		return Result.ok();
	}
	
	/**
	 * 分页带条件查询学生信息
	 *
	 * @param pageNo   当前页
	 * @param pageSize 每页显示的数量
	 * @return
	 */
	@GetMapping("/getStudentByOpr/{pageNo}/{pageSize}")
	public Result<Page<Student>> getStudent(
			@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,
			Student student
	) {
		// 获取 总记录数
		int count = studentService.getStudentByOprCount(student);
		// 分页条件查询
		List<Student> students = studentService.getStudentByOpr(student, pageNo, pageSize);
		// 条件分页对象
		Page<Student> page = new Page<>(students, count, pageSize, pageNo);
		
		// 封装Result返回
		return Result.ok(page);
	}
}
