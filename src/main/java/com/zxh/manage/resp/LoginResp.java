package com.zxh.manage.resp;

import lombok.Data;

import java.util.Map;

/**
 * @author zxh
 * @create 2021-11-15-19:08
 * @statement 登录响应
 */
@Data
public class LoginResp extends Resp {
    private Map<String,Object> data;
}


