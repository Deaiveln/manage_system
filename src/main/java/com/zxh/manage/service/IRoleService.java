package com.zxh.manage.service;

import com.zxh.manage.pojo.Dept;
import com.zxh.manage.pojo.Role;
import com.zxh.manage.resp.DeptResp;
import com.zxh.manage.resp.RoleModuleResp;
import com.zxh.manage.resp.RoleResp;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-17:50
 * @statement
 */
public interface IRoleService {
    /**
     * 获取所有角色信息
     * @return
     * @param roleName roleNo
    aram userMobile
     */
    List<RoleResp> getList(String roleName, String roleNo);

    /**
     * 获取部门记录数量
     */
    int getCount();

    /**
     * 添加新部门
     * @param Role
     * @return
     */
    int insert(Role role);

    /**
     * 编辑部门信息
     * @param Role
     * @return
     */
    int update(Role role);

    /**
     * 删除部门
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据角色id获取其菜单权限
     * @param roleId
     * @return
     */
    List<RoleModuleResp> getModule(Long roleId);

    /**
     * 保存权限
     * @param roleId
     * @param moduleIds
     * @return
     */
    Boolean saveModule(Long roleId,List<Long> moduleIds);
}
