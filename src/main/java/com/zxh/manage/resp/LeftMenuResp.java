package com.zxh.manage.resp;

import lombok.Data;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-06-12:47
 * @statement 左侧菜单的响应数据
 */
@Data
public class LeftMenuResp {
    private Long moduleId;
    private String moduleName;
    private String moduleIcon;
    private String moduleUrl;
    private int moduleLevel;
    private int moduleOrder;
    private Long parentId;
    private List<LeftMenuResp> menus; //子菜单
}
