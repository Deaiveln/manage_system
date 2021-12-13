package com.zxh.manage.resp;

import lombok.Data;

import java.sql.Date;

/**
 * @author zxh
 * @create 2021-12-02-14:15
 * @statement
 */

@Data
public class DeptResp {
    private Long deptId;
    private String deptName;
    private String deptNo;
    private String addUser;
    private Date addTime;
    private String editUser;
    private Date editTime;
}
