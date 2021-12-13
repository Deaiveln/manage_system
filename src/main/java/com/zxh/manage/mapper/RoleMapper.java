package com.zxh.manage.mapper;

import com.zxh.manage.pojo.Role;
import com.zxh.manage.resp.DeptResp;
import com.zxh.manage.resp.RoleModuleResp;
import com.zxh.manage.resp.RoleResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleResp> selectAll(@Param("roleName")String roleName, @Param("roleNo")String roleNo);

    int getCount();

    /**
     * 根据角色id获取它的菜单权限
     * @param roleId
     * @return
     */
    List<RoleModuleResp> getModuleByRoleId(@Param("roleId") Long roleId);

    /**
     * 保存权限
     * @param roleId
     * @param moduleId
     * @return
     */
    Integer saveModule(@Param("roleId") Long roleId,@Param("moduleId") Long moduleId);

    /**
     * 删除权限
     * @param roleId
     * @param moduleId
     * @return
     */
    Integer deleteModule(@Param("roleId") Long roleId,@Param("moduleId") Long moduleId);

    /**
     * 查询是否具有权限
     * @param roleId
     * @param moduleId
     * @return
     */
    List<Long> selectModule(@Param("roleId") Long roleId,@Param("moduleId") Long moduleId);
}