package com.zxh.manage.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Module{
    private Long moduleId;

    private String moduleName;

    private String moduleIcon;

    private String moduleUrl;

    private Integer moduleLevel;

    private Integer moduleOrder;

    private Long parentId;

    private Long addUser;

    private Long editUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date addTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date editTime;
}