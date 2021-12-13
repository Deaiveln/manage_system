package com.zxh.manage.service.impl;

import com.zxh.manage.mapper.ModuleMapper;
import com.zxh.manage.pojo.Module;
import com.zxh.manage.resp.LeftMenuResp;
import com.zxh.manage.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<LeftMenuResp> getLeftMenu() {
        return mapper.getLeftMenu();
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
