package com.zxh.manage.service;

import com.zxh.manage.pojo.Dept;
import com.zxh.manage.pojo.Role;
import com.zxh.manage.pojo.User;
import com.zxh.manage.resp.UserResp;

import java.util.List;

/**
 * @author zxh
 * @create 2021-11-26-20:52
 * @statement
 */
public interface IUserListService {
    /**
     * 获取所有用户信息
     * @return
     * @param userName
     * @param userMobile
     */
    List<UserResp> getList(String userName, String userMobile);

    /**
     * 获取用户记录数量
     */
    int getCount();

    /**
     * 编辑用户信息
     * @return
     */
    int update(User user);

    /**
     * 添加新用户
     * @return
     */
    int insert(User user);

    /**
     * 根据id查询用户
     * @param userId 用户id
     * @return 用户信息
     */
    User selectById(Long userId);

    /**
     * 根据id删除用户
     * @param userId
     * @return
     */
    int deleteById(Long userId);

    /**
     * 获取角色信息
     * @return
     */
    List<Role> selectRole();

    /**
     * 获取部门信息
     * @return
     */
    List<Dept> selectDept();

}
