package com.www.zhxy.entity;

import lombok.Data;

/**
 * @author Www
 * @project: sms
 * @description: 学生信息
 */
@Data
public class Student {

    private Integer id;
    private String sno;
    private String name;
    /**
     * default
     */
    private char gender = '男';
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String introducation;
    /**
     * 存储头像的项目路径
     */
    private String portraitPath;
    /**
     * 班级名称
     */
    private String clazzName;

}
