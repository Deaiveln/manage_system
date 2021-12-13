package com.zxh.manage.service.impl;

import com.zxh.manage.mapper.RoleMapper;
import com.zxh.manage.pojo.Role;
import com.zxh.manage.resp.RoleModuleResp;
import com.zxh.manage.resp.RoleResp;
import com.zxh.manage.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-17:52
 * @statement
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper mapper;

    @Override
    public List<RoleResp> getList(String roleName, String roleNo) {
        return mapper.selectAll(roleName,roleNo);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }

    @Override
    public int insert(Role role) { return mapper.insertSelective(role);}

    @Override
    public int update(Role role) {
        return mapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(Long id) {
        mapper.deleteModule(id,null);
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<RoleModuleResp> getModule(Long roleId) {
        List<RoleModuleResp> list = mapper.getModuleByRoleId(roleId);
        for (RoleModuleResp resp : list){
            if (resp.getRId() != null){
                resp.setChecked(true);
            }
        }
        return list;
    }

    @Override
    public Boolean saveModule(Long roleId, List<Long> moduleIds) {
        List<Long> oldModules = mapper.selectModule(roleId, null);
        List<Long> delModules = compare(moduleIds, oldModules);
        List<Long> addmodules = compare(oldModules, moduleIds);
        for (Long module:delModules){
            if (mapper.deleteModule(roleId,module) == 0){
                return false;
            }
        }
        for (Long module:addmodules){
            if (mapper.saveModule(roleId,module) == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 返回两个列表中的不同元素
     * @param t1
     * @param t2
     * @param <T>
     * @return
     */
    private <T> List<T> compare(List<T> t1, List<T> t2) {
        List<T> diff = new ArrayList<>();//用来存放2个数组中不相同的元素
        for (T t : t2) {
            if (!t1.contains(t)) {
                diff.add(t);
            }
        }
        return diff;
    }
}
