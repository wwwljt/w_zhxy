package com.www.zhxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 跳转到系统首页
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/8  15:05  星期四
 * <p>
 */
@Controller
public class ZhxyIndexController {
	/**
	 * 首页
	 *
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		return "forward:index.html";
	}
}
