package com.zxh.manage.service.impl;

import com.zxh.manage.mapper.UserMapper;
import com.zxh.manage.resp.LoginResp;
import com.zxh.manage.resp.UserResp;
import com.zxh.manage.service.ILoginService;
import com.zxh.manage.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zxh
 * @create 2021-11-15-19:24
 * @statement
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private UserMapper mapper;
    
    @Override
    public LoginResp login(String username, String password) {
        LoginResp loginResp = new LoginResp();
        Map<String, Object> data = mapper.login(username, password);
        if (data == null){
            loginResp.setSuccess(false);
            loginResp.setMsg("账号或密码不存在");
            return loginResp;
        }
        data.put("token",JWTUtil.getToken(data));
        loginResp.setSuccess(true);
        loginResp.setData(data);
        return loginResp;
    }
}
