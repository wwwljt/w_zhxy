package com.www.zhxy.entity;

import lombok.Data;

/**
 * @author Www
 * @project: sms
 * @description: 班级信息
 */
@Data
public class Clazz {
	
	/**
	 * 班级信息
	 * <p>
	 * 班级Id
	 */
	private Integer id;
	/**
	 * 班级名称
	 */
	private String name;
	/**
	 * 班级人数
	 */
	private String number;
	/**
	 * 班级人数
	 */
	private String introducation;
	/**
	 * 班主任信息
	 * <p>
	 * 班主任姓名
	 */
	private String headmaster;
	
	/**
	 * 班主任电话
	 */
	private String telephone;
	/**
	 * 班主任邮箱
	 */
	private String email;
	/**
	 * 班级所属年级
	 */
	private String gradeName;
	
	
}
