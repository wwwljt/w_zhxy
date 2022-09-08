package com.www.zhxy.controller;

import com.www.zhxy.entity.Clazz;
import com.www.zhxy.service.ClazzService;
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
 * 创建时间: 2022/9/8  11:34  星期四
 * <p>
 */
@RestController
@RequestMapping("/sms/clazzController")
public class ClazzController {
	@Autowired
	private ClazzService clazzService;
	
	/**
	 * 获取所有 Clazz
	 *
	 * @return
	 */
	@GetMapping("/getClazzs")
	public Result<List<Clazz>> getClazz() {
		List<Clazz> clazzList = clazzService.getAllClazz();
		return Result.ok(clazzList);
	}
	
	/**
	 * 条件分页查询
	 *
	 * @param pageNo
	 * @param pageSize
	 * @param clazz
	 * @return
	 */
	@GetMapping("/getClazzsByOpr/{pageNo}/{pageSize}")
	public Result<Page<Clazz>> getClazzByOpr(
			@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,
			Clazz clazz
	) {
		System.out.println("clazz = " + clazz);
		// 根据条件获取总记录数
		Integer count = clazzService.getClazzCount(clazz);
		// 条件分页数据
		List<Clazz> clazzList = clazzService.getClazzByOpr(clazz, pageNo, pageSize);
		Page<Clazz> clazzPage = new Page<>(clazzList, count, pageSize, pageNo);
		return Result.ok(clazzPage);
	}
}
