package com.zxh.manage.service.impl;

import com.zxh.manage.mapper.DeptMapper;
import com.zxh.manage.pojo.Dept;
import com.zxh.manage.resp.DeptResp;
import com.zxh.manage.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-14:59
 * @statement
 */
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private DeptMapper mapper;

    @Override
    public List<DeptResp> getList(String deptName, String deptNo) {
        return mapper.selectAll(deptName,deptNo);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }

    @Override
    public int insert(Dept dept) {
        return mapper.insertSelective(dept);
    }

    @Override
    public int update(Dept dept) {
        return mapper.updateByPrimaryKeySelective(dept);
    }

    @Override
    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
