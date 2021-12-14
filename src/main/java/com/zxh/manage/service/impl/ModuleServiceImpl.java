package com.zxh.manage.service.impl;

import com.zxh.manage.mapper.ModuleMapper;
import com.zxh.manage.pojo.Module;
import com.zxh.manage.resp.LeftMenuResp;
import com.zxh.manage.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 * @create 2021-12-06-14:07
 * @statement
 */
@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleMapper mapper;

    @Override
    public List<LeftMenuResp> getLeftMenu(Long id) {
        List<Long> moduleIds = mapper.selectModuleIds(id);
        //如果父节点未选中，子节点选中，则把父节点也添加到列表中
        Module module = null;
        Long parentId = null;
        List<Long> moduleIdsCopy = new ArrayList<>();
        moduleIdsCopy.addAll(moduleIds);
        for (Long moduleId:moduleIdsCopy){
            module = mapper.selectByPrimaryKey(moduleId);
            parentId = module.getParentId();
            if (parentId != null){
                if (!moduleIds.contains(parentId)){
                    moduleIds.add(parentId);
                }
            }
        }
        return mapper.getLeftMenu(moduleIds);
    }

    @Override
    public List<LeftMenuResp> getParent() {
        return mapper.getParent();
    }

    @Override
    public LeftMenuResp getNode(Long moduleId) {
        return mapper.getNode(moduleId);
    }

    @Override
    public Integer update(Module module) {
        return mapper.updateByPrimaryKeySelective(module);
    }

    @Override
    public Integer insert(Module module) {
        return mapper.insertSelective(module);
    }

    @Override
    public Integer delete(Long moduleId) {
        return mapper.deleteByPrimaryKey(moduleId);
    }


}
