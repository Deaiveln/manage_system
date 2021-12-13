package com.zxh.manage.resp;

import com.zxh.manage.pojo.Dept;
import com.zxh.manage.pojo.Role;
import lombok.Data;

import java.util.List;

/**
 * @author zxh
 * @create 2021-11-26-20:47
 * @statement
 */


@Data
public class UserListResp extends Resp{
    private int count;
    private List<UserResp> data;
    private List<Role> roleData;
    private List<Dept> deptData;
}
