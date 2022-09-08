package com.www.zhxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Www
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    /**
     * 头像的图片路径
     */
    private String portraitPath;
}
