package com.zxh.manage.resp;

import lombok.Data;

import java.sql.Date;

/**
 * @author zxh
 * @create 2021-12-02-17:42
 * @statement
 */
//       addUser: null,
//       editUser: null,
//       addTime: 1526349942000,
//       editTime: 1526437443000,
//       roleId: 97,
//       systemNo: '2',
//       roleNo: '2',
//       roleName: '2'
@Data
public class RoleResp {
    private Long roleId;
    private String roleName;
    private String roleNo;
    private String addUser;
    private Date addTime;
    private String editUser;
    private Date editTime;
}
