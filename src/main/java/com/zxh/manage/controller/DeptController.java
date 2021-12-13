package com.zxh.manage.controller;

import com.github.pagehelper.PageHelper;
import com.zxh.manage.pojo.Dept;
import com.zxh.manage.resp.DeptListResp;
import com.zxh.manage.resp.DeptResp;
import com.zxh.manage.resp.Resp;
import com.zxh.manage.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-13:52
 * @statement 部门管理
 */
//       addUser: null,
//       editUser: null,
//       addTime: 1526349555000,
//       editTime: 1526349565000,
//       deptId: 12,
//       deptName: '1',
//       deptNo: '11',
//       parentId: 1

//    formInline: {
//            page: 1,
//            limit: 10,
//            varLable: '',
//            varName: '',
//            token: localStorage.getItem('logintoken')
//            },
@RestController
public class DeptController {
    @Autowired
    private IDeptService service;

    @PostMapping("/api/Dept/list")
    public DeptListResp getList(@RequestParam(value = "page",required = false) Integer page,
                                @RequestParam(value = "limit",required = false) Integer limit,
                                @RequestParam(value = "deptName",required = false) String deptName,
                                @RequestParam(value = "deptNo",required = false) String deptNo){
        DeptListResp deptListResp = new DeptListResp();
        PageHelper.startPage(page,limit);
        List<DeptResp> list = service.getList(deptName, deptNo);
        if (list == null){
            deptListResp.setSuccess(false);
            deptListResp.setMsg("信息获取失败");
        }else{
            deptListResp.setData(list);
            deptListResp.setCount(service.getCount());
            deptListResp.setSuccess(true);
        }
        return  deptListResp;
    }


    @PostMapping("/api/Dept/save")
    public Resp save(Dept dept){
        Resp resp = new Resp();
        if (dept.getDeptId() == null){
            if (service.insert(dept) == 1){
                resp.setSuccess(true);
            }else {
                resp.setMsg("添加失败");
                resp.setSuccess(false);
            }
        }else {
            if (service.update(dept) == 1){
                resp.setSuccess(true);
            }else {
                resp.setMsg("编辑失败");
                resp.setSuccess(false);
            }
        }
        return resp;
    }


    @GetMapping("/api/Dept/delete")
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
}
