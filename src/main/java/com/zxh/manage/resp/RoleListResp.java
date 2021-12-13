package com.zxh.manage.resp;

import lombok.Data;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-17:44
 * @statement
 */
@Data
public class RoleListResp extends Resp {
    private int count;
    private List<RoleResp> data;
}
