package com.zxh.manage.resp;

import lombok.Data;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-14:20
 * @statement
 */
@Data
public class DeptListResp extends Resp {
    private int count;
    private List<DeptResp> data;
}
