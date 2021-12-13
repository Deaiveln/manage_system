package com.zxh.manage.controller;

import com.github.pagehelper.PageHelper;
import com.zxh.manage.pojo.Role;
import com.zxh.manage.resp.*;
import com.zxh.manage.service.IRoleService;
import com.zxh.manage.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-17:33
 * @statement
 */

@RestController
public class RoleController {
    @Autowired
    private IRoleService service;


    @PostMapping("/api/Role/list")
    public RoleListResp getlist(@RequestParam(value = "page",required = false) Integer page,
                                @RequestParam(value = "limit",required = false) Integer limit,
                                @RequestParam(value = "roleName",required = false) String roleName,
                                @RequestParam(value = "roleNo",required = false) String roleNo){
        RoleListResp roleListResp = new RoleListResp();
        PageHelper.startPage(page,limit);
        List<RoleResp> list = service.getList(roleName, roleNo);
        if (list == null){
            roleListResp.setSuccess(false);
            roleListResp.setMsg("信息获取失败");
        }else {
            roleListResp.setData(list);
            roleListResp.setCount(service.getCount());
            roleListResp.setSuccess(true);
        }
        return roleListResp;
    }


    @PostMapping("/api/Role/save")
    public Resp save(Role role){
        Resp resp = new Resp();
        if (role.getRoleId() == null){
            if (service.insert(role) == 1){
                resp.setSuccess(true);
            }else {
                resp.setMsg("添加失败");
                resp.setSuccess(false);
            }
        }else {
            if (service.update(role) == 1){
                resp.setSuccess(true);
            }else {
                resp.setMsg("编辑失败");
                resp.setSuccess(false);
            }
        }
        return resp;
    }

    @DeleteMapping("/api/Role/delete")
    public Resp delete(Long ids){
        Resp resp = new Resp();
        if (service.delete(ids) == 1){
            resp.setSuccess(true);
        }else{
            resp.setSuccess(false);
            resp.setMsg("删除失败");
        }
        return resp;
    }

    @GetMapping("/api/RoleRight/tree")
    public RoleModuleListResp getModuleList(Long ids){
        RoleModuleListResp resp = new RoleModuleListResp();
        List<RoleModuleResp> list = service.getModule(ids);
        if (list != null){
            resp.setSuccess(true);
            resp.setData(list);
        }else{
            resp.setSuccess(false);
            resp.setMsg("权限获取失败");
        }
        return resp;
    }

    @PostMapping("/api/RoleRight/save")
    public Resp saveModule(@RequestParam("roleId")Long roleId,
                           @RequestParam("moduleIds")String moduleIds){
        ArrayList<Integer> intList = JsonUtil.jsonToObj(moduleIds, ArrayList.class);
        List<Long> moduleList = new ArrayList<>();
        for (Integer i :intList){
            moduleList.add(i.longValue());
        }
        Resp resp = new Resp();
        if (service.saveModule(roleId,moduleList)){
            resp.setSuccess(true);
        }else {
            resp.setSuccess(false);
            resp.setMsg("保存失败");
        }
        return resp;
    }
}
