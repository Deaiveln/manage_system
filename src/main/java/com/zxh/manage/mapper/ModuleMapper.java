package com.zxh.manage.mapper;

import com.zxh.manage.pojo.Module;
import com.zxh.manage.resp.LeftMenuResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ModuleMapper {
    int deleteByPrimaryKey(Long moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Long moduleId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    /**
     * 查询左侧菜单
     * @return
     * @param moduleIds
     */
    List<LeftMenuResp> getLeftMenu(List<Long> moduleIds);

    /**
     * 获取父级菜单
     * @return
     */
    List<LeftMenuResp> getParent();

    /**
     * 获取节点信息
     * @param id
     * @return
     */
    LeftMenuResp getNode(@Param("id")Long id);

    /**
     * 根据用户id查询出角色id再查询出菜单权限
     * @param userId
     * @return
     */
    List<Long> selectModuleIds(Long userId);
}