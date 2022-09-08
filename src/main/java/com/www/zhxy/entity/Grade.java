package com.www.zhxy.entity;

import lombok.Data;

/**
 * @author Www
 * @project: sms
 * @description: 年级及年级主任信息
 */
@Data
public class Grade {
	
	/**
	 * 年级信息
	 * 年级ID
	 */
	private Integer id;
	/**
	 * 年级名称
	 */
	private String name;
	/**
	 * 年级介绍
	 */
	private String introducation;
	/**
	 * 年级主任信息
	 * <p>
	 * 年级主任姓名
	 */
	private String manager;
	/**
	 * 年级主任邮箱
	 */
	private String email;
	/**
	 * 年级主任电话
	 */
	private String telephone;
	
}