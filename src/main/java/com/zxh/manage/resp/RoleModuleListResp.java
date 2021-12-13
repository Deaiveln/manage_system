package com.zxh.manage.resp;

import lombok.Data;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-08-14:09
 * @statement
 */
@Data
public class RoleModuleListResp extends Resp {
    List<RoleModuleResp> data;
}
