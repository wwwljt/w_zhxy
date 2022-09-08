package com.www.zhxy.entity;

import lombok.Data;

/**
 * @author Www
 * @project: ssm_sms
 * @description: 用户登录表单信息
 */
@Data
public class LoginForm {

    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;

}
