package com.www.zhxy.controller;

import com.www.zhxy.entity.Admin;
import com.www.zhxy.entity.LoginForm;
import com.www.zhxy.entity.Student;
import com.www.zhxy.entity.Teacher;
import com.www.zhxy.service.AdminService;
import com.www.zhxy.service.StudentService;
import com.www.zhxy.service.TeacherService;
import com.www.zhxy.util.CreateVerifiCodeImage;
import com.www.zhxy.util.JwtHelper;
import com.www.zhxy.util.Result;
import com.www.zhxy.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author Www
 * <p>
 * 邮箱： 483223455@qq.com
 * <p>
 * 创建时间: 2022/9/7  17:03  星期三
 * <p>
 */
@RestController
@RequestMapping("/sms/system")
public class SystemController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	
	
	/**
	 * 通过token口令获取当前登录的用户信息的方法
	 *
	 * @param token
	 * @return
	 */
	@GetMapping("/getInfo")
	public Result<Map<String, Object>> getInfoByToken(@RequestHeader("token") String token) {
		boolean expiration = JwtHelper.isExpiration(token);
		if (expiration) {
			return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
		}
		//从token中解析出 用户id 和用户的类型
		Long userId = JwtHelper.getUserId(token);
		Integer userType = JwtHelper.getUserType(token);
		
		
		Map<String, Object> map = new LinkedHashMap<>();
		if (userType != null) {
			switch (userType) {
				case 1:
					Admin admin = adminService.getAdminById(userId);
					map.put("userType", 1);
					map.put("user", admin);
					break;
				case 2:
					Student student = studentService.getStudentById(userId);
					map.put("userType", 2);
					map.put("user", student);
					break;
				case 3:
					Teacher teacher = teacherService.getByTeacherById(userId);
					map.put("userType", 3);
					map.put("user", teacher);
					break;
				default:
					System.out.println("没有此角色");
			}
		}
		return Result.ok(map);
	}
	
	/**
	 * 用户登录
	 *
	 * @param loginForm
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	public Result login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
		// 验证码校验
		HttpSession session = request.getSession();
		String sessionVerifiCode = (String) session.getAttribute("verifiCode");
		String loginVerifiCode = loginForm.getVerifiCode();
		if ("".equals(sessionVerifiCode) || null == sessionVerifiCode) {
			return Result.fail().message("验证码失效,请刷新后重试");
		}
		if (!sessionVerifiCode.equalsIgnoreCase(loginVerifiCode)) {
			return Result.fail().message("验证码有误,请小心输入后重试");
		}
		// 从session域中移除现有验证码
		session.removeAttribute("verifiCode");
		// 分用户类型进行校验
		// 准备一个map用户存放响应的数据
		Map<String, Object> map = new LinkedHashMap<>();
		
		switch (loginForm.getUserType()) {
			case 1:
				try {
					Admin admin = adminService.login(loginForm);
					if (null != admin) {
						// 用户的类型和用户id转换成一个密文,以token的名称向客户端反馈
						map.put("token", JwtHelper.createToken(admin.getId().longValue(), 1));
					} else {
						throw new RuntimeException("用户名或者密码有误");
					}
					return Result.ok(map);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return Result.fail().message(e.getMessage());
				}
			case 2:
				try {
					Student student = studentService.login(loginForm);
					if (null != student) {
						// 用户的类型和用户id转换成一个密文,以token的名称向客户端反馈
						map.put("token", JwtHelper.createToken(student.getId().longValue(), 2));
					} else {
						throw new RuntimeException("用户名或者密码有误");
					}
					return Result.ok(map);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return Result.fail().message(e.getMessage());
				}
			case 3:
				try {
					Teacher teacher = teacherService.login(loginForm);
					if (null != teacher) {
						// 用户的类型和用户id转换成一个密文,以token的名称向客户端反馈
						map.put("token", JwtHelper.createToken(teacher.getId().longValue(), 3));
					} else {
						throw new RuntimeException("用户名或者密码有误");
					}
					return Result.ok(map);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return Result.fail().message(e.getMessage());
				}
			default:
				System.out.println("没有此角色！！！");
		}
		return Result.fail().message("查无此用户");
		
	}
	
	/**
	 * 获取验证码
	 *
	 * @param request
	 * @param response
	 */
	@GetMapping("/getVerifiCodeImage")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) {
		// 获取验证码图片
		BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
		// 获取验证码
		String verifyCode = new String(CreateVerifiCodeImage.getVerifiCode());
		// 将 验证码文本放入session 域
		HttpSession session = request.getSession();
		session.setAttribute("verifiCode", verifyCode);
		// 将验证码图响应给浏览器
		try {
			ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
