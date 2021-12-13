package com.zxh.manage.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Role{
    private Long roleId;

    private String roleName;

    private Date updateTime;

    private Long updateUser;

    private String roleNo;

    private Long addUser;

    private Date addTime;
}