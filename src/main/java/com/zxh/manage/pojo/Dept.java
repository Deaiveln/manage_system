package com.zxh.manage.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class Dept {
    private Long deptId;

    private String deptName;

    private Date updateTime;

    private Long updateUser;

    private Long addUser;

    private Date addTime;

    private String deptNo;

}