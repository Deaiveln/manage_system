package com.zxh.manage.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zxh.manage.pojo.User;
import com.zxh.manage.resp.Resp;
import com.zxh.manage.resp.UserListResp;
import com.zxh.manage.resp.UserResp;
import com.zxh.manage.service.IUserListService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zxh
 * @create 2021-11-26-16:09
 * @statement 用户管理相关的控制器
 */
@RestController
@Api("用户管理相关的api")
public class UserController {
    @Autowired
    private IUserListService service;

    /**
     * 获取用户列表
     * @return
     */
    @PostMapping("/api/User/list")
    public UserListResp getUserList(@RequestParam(value = "userName",required = false)String userName,
                                    @RequestParam(value ="userMobile", required = false)String userMobile,
                                    @RequestParam(value ="page", required = false)Integer page,
                                    @RequestParam(value ="limit", required = false)Integer limit){
        UserListResp userListResp = new UserListResp();
        PageHelper.startPage(page,limit);
        List<UserResp> list = service.getList(userName,userMobile);
        if (list == null){
            userListResp.setSuccess(false);
            userListResp.setMsg("用户信息不存在");
            return userListResp;
        }
        userListResp.setSuccess(true);
        userListResp.setData(list);
        //查询出部门和角色信息
        userListResp.setRoleData(service.selectRole());
        userListResp.setDeptData(service.selectDept());
        userListResp.setCount(service.getCount());
        return userListResp;
    }

    /**
     * 添加和编辑用户的控制器
     * @param user 接受表单信息
     * @return Resp
     */
    @PostMapping("/api/User/save")
    public Resp save(User user){
        Resp resp = new Resp();
        if (user.getUserId() == null){
            //添加用户
            if (service.insert(user) == 1){
                resp.setSuccess(true);
            }else {
                resp.setSuccess(false);
                resp.setMsg("添加失败");
            }
        }else{
            //编辑用户
            if (service.update(user) == 1){
                resp.setSuccess(true);
            }else{
                resp.setSuccess(false);
                resp.setMsg("编辑失败");
            }
        }
        return resp;
    }

    /**
     * 重置密码
     * @return
     */
    @PostMapping("/api/User/pwd")
    public Resp resetPwd(Long userId){
        Resp resp = new Resp();
        User user = service.selectById(userId);
        user.setPassword("666666");
        if (service.update(user) == 1){
            resp.setSuccess(true);
        }else{
            resp.setSuccess(false);
            resp.setMsg("重置失败");
        }
        return resp;
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @DeleteMapping("/api/User/delete")
    public Resp delete(Long ids){
        Resp resp = new Resp();
        if (service.deleteById(ids) == 1){
            resp.setSuccess(true);
        }else{
            resp.setSuccess(false);
            resp.setMsg("删除失败");
        }
        return resp;
    }
}
