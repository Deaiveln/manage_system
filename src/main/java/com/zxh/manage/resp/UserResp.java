package com.zxh.manage.resp;

import lombok.Data;

/**
 * @author zxh
 * @create 2021-11-15-18:41
 * @statement 响应给前端的用户信息
 */

//       addUser: '1',
//       editUser: '1',
//       addTime: null,
//       editTime: 1527411068000,
//       userId: 1,
//       systemNo: 'pmd',
//       userName: 'root',
//       userPassword: 'e10adc3949ba59abbe56e057f20f883e',
//       userRealName: '超级管理员',
//       userSex: '女',
//       userMobile: '138123456789',
//       userEmail: '111@qq.com',
//       isLock: 'N',
//       deptId: 1,
//       deptName: 'xxxx',
//       roleId: 1
@Data
public class UserResp {
    private Long userId;
    private String userName;
    private String userRealName;
    private Long roleId;
    private Long deptId;
    private String roleName;
    private String deptName;
    private Character userSex;
    private String userMobile;
    private String userEmail;
    private char isLock = 'N';
}
