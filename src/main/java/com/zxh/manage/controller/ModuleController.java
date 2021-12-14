package com.zxh.manage.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zxh.manage.pojo.Module;
import com.zxh.manage.resp.LeftMenuListResp;
import com.zxh.manage.resp.LeftMenuResp;
import com.zxh.manage.resp.NodeResp;
import com.zxh.manage.resp.Resp;
import com.zxh.manage.service.IModuleService;
import com.zxh.manage.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zxh
 * @create 2021-12-05-15:50
 * @statement 菜单管理
 */

@RestController
public class ModuleController {
    @Autowired
    private IModuleService service;

    /**
     * 网页左侧菜单的查询
     * 根据用户的角色信息来获取菜单
     * @return
     */
    @GetMapping("/api/menu")
    public LeftMenuListResp getLeftMenu(HttpServletRequest request){
        LeftMenuListResp resp = new LeftMenuListResp();
        //取出token
        String token = request.getHeader("token");
        if (token == null){
            token = request.getParameter("token");
        }
        DecodedJWT decodedJWT = JWTUtil.checkSign(token);
        Long id = decodedJWT.getClaim("id").asLong();
        List<LeftMenuResp> leftMenu = service.getLeftMenu(id);
        if (leftMenu == null){
            resp.setSuccess(false);
            resp.setMsg("菜单获取失败");
        }else {
            resp.setData(leftMenu);
            resp.setSuccess(true);
        }
        return resp;
    }

    /**
     * 系统管理菜单模块的查询
     * @return
     */
    @PostMapping("/api/Module/list")
    public LeftMenuListResp getList(){
        LeftMenuListResp resp = new LeftMenuListResp();
        List<LeftMenuResp> leftMenu = service.getLeftMenu(null);
        if (leftMenu == null){
            resp.setSuccess(false);
            resp.setMsg("菜单获取失败");
        }else {
            resp.setData(leftMenu);
            resp.setSuccess(true);
        }
        return resp;
    }

    /**
     * 获取父级菜单
     */
    @PostMapping("/api/Module/nodes")
    public LeftMenuListResp getParent(){
        LeftMenuListResp resp = new LeftMenuListResp();
        List<LeftMenuResp> menu = service.getParent();
        if (menu == null){
            resp.setSuccess(false);
            resp.setMsg("父级菜单获取失败");
        }else {
            resp.setData(menu);
            resp.setSuccess(true);
        }
        return resp;
    }

    /**
     * 获取节点信息
     * @param moduleId
     * @return
     */
    @GetMapping("/api/Module/get")
    public NodeResp getNode(@RequestParam("ids")Long moduleId){
        NodeResp resp = new NodeResp();
        LeftMenuResp node = service.getNode(moduleId);
        if (node == null){
            resp.setSuccess(false);
            resp.setMsg("节点获取失败");
        }else {
            resp.setData(node);
            resp.setSuccess(true);
        }
        return resp;
    }

    /**
     * 保存或者添加节点
     * @param module
     * @return
     */
    @PostMapping("/api/Module/save")
    public Resp save(Module module){
        Resp resp = new Resp();
        if (module.getModuleId() == null){
            if (service.insert(module) == 1){
                resp.setSuccess(true);
            }else {
                resp.setSuccess(false);
                resp.setMsg("添加失败");
            }
        }else {
            if (service.update(module) == 1){
                resp.setSuccess(true);
            }else {
                resp.setSuccess(false);
                resp.setMsg("保存失败");
            }
        }
        return resp;
    }

    @DeleteMapping("/api/Module/delete")
    public Resp delete(@RequestParam("ids")Long moduleId){
        Resp resp = new Resp();
        if(service.delete(moduleId) == 1){
            resp.setSuccess(true);
        }else {
            resp.setSuccess(false);
            resp.setMsg("删除失败");
        }
        return resp;
    }
}
