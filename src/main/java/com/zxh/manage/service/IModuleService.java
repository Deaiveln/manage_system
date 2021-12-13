package com.zxh.manage.service;

import com.zxh.manage.pojo.Module;
import com.zxh.manage.resp.LeftMenuResp;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-06-14:06
 * @statement
 */

public interface IModuleService {
    /**
     * 查询左侧菜单
     * @return
     */
    List<LeftMenuResp> getLeftMenu();

    /**
     * 查询父级菜单
     * @return
     */
    List<LeftMenuResp> getParent();

    /**
     * 查询节点信息
     * @return
     */
    LeftMenuResp getNode(Long moduleId);

    /**
     * 更新菜单
     * @param module
     * @return
     */
    Integer update(Module module);

    /**
     * 添加菜单
     * @param module
     * @return
     */
    Integer insert(Module module);

    /**
     * 删除菜单
     * @param moduleId
     * @return
     */
    Integer delete(Long moduleId);
}
