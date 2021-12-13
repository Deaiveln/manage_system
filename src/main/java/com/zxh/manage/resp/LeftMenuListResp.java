package com.zxh.manage.resp;

import lombok.Data;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-06-12:50
 * @statement
 */
@Data
public class LeftMenuListResp extends Resp{
    private List<LeftMenuResp> data;
}
