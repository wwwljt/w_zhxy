package com.www.zhxy.entity;

import lombok.Data;

/**
 * @author Www
 * @project: sms
 * @description: 教师信息
 */
@Data
public class Teacher {

    private Integer id;
    private String tno;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String clazzName;
    /**
     * 存储头像的项目路径
     */
    private String portraitPath;

//    @TableLogic
//    private Integer isDeleted;
}
