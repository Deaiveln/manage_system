package com.zxh.manage.pojo;

import lombok.Data;

import java.sql.Date;
@Data
public class User{
    private Long userId;

    private String userName;

    private String userRealName;

    private String password;

    private Long deptId;

    private Long roleId;

    private char userSex;

    private String userMobile;

    private String userEmail;

    private Long createUser;

    private Date createDate;

    private Long updateUser;

    private Date updateDate;
}