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
     */
    List<LeftMenuResp> getLeftMenu();

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
}