package com.zxh.manage.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zxh.manage.resp.LoginResp;
import com.zxh.manage.resp.UserResp;
import com.zxh.manage.service.ILoginService;
import com.zxh.manage.utils.JWTUtil;
import com.zxh.manage.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

/**
 * @author zxh
 * @create 2021-11-15-13:41
 * @statement
 */

@RestController
@Api(value = "登录相关的api")
public class LoginController {
    @Autowired
    private ILoginService service;

    @PostMapping("/api/login")
    @ApiOperation(value = "用户登录的方法")
    public LoginResp login(@RequestParam("username")String username,
                           @RequestParam("password")String password){
        return service.login(username, password);

    }

}
