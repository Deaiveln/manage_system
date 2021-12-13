package com.zxh.manage.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-08-13:37
 * @statement 角色权限的响应
 */
@Data
public class RoleModuleResp {
    private Long id;
    @JsonProperty("pId")
    private Long pId;
    private String name;
    private Boolean open;
    private Boolean checked = false;
    private Long rId;
    private List<RoleModuleResp> children;

}
