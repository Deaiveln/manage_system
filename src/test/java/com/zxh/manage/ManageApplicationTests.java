package com.zxh.manage;

import com.zxh.manage.mapper.DeptMapper;
import com.zxh.manage.mapper.ModuleMapper;
import com.zxh.manage.mapper.RoleMapper;
import com.zxh.manage.mapper.UserMapper;
import com.zxh.manage.resp.LeftMenuResp;
import com.zxh.manage.resp.RoleModuleResp;
import com.zxh.manage.resp.UserResp;
import com.zxh.manage.service.IRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManageApplicationTests {
    @Autowired
    RoleMapper mapper;

    @Autowired
    IRoleService service;

    @Test
    void contextLoads() {
        List<RoleModuleResp> module = service.getModule(1L);
        System.out.println(module);
    }



}
