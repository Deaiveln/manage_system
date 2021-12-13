package com.zxh.manage.service.impl;

import com.zxh.manage.mapper.UserMapper;
import com.zxh.manage.pojo.Dept;
import com.zxh.manage.pojo.Role;
import com.zxh.manage.pojo.User;
import com.zxh.manage.resp.UserResp;
import com.zxh.manage.service.IUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxh
 * @create 2021-11-26-20:56
 * @statement
 */
@Service
public class UserListServiceImpl implements IUserListService {
    @Autowired
    UserMapper mapper;


    @Override
    public List<UserResp> getList(String userName, String userMobile) { return mapper.selectAll(userName,userMobile); }

    @Override
    public int getCount() {
        return mapper.getCount();
    }

    @Override
    public int update(User user) {
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insert(User user) {
        return mapper.insertSelective(user);
    }

    @Override
    public User selectById(Long userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public int deleteById(Long userId) {
        return mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public List<Role> selectRole() {
        return mapper.selectRole();
    }

    @Override
    public List<Dept> selectDept() {
        return mapper.selectDept();
    }


}
