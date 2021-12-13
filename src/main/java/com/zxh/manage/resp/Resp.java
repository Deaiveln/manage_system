package com.zxh.manage.resp;

import lombok.Data;

/**
 * @author zxh
 * @create 2021-11-15-13:43
 * @statement 基础的响应类
 */
@Data
public class Resp {
    private boolean success;
    private String msg;
}
