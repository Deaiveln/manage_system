package com.zxh.manage.service;

import com.zxh.manage.resp.LoginResp;
import org.springframework.stereotype.Service;

/**
 * @author zxh
 * @create 2021-11-15-19:21
 * @statement
 */

public interface ILoginService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    LoginResp login(String username, String password);
}
