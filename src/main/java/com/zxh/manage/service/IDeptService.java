package com.zxh.manage.service;

import com.zxh.manage.pojo.Dept;
import com.zxh.manage.resp.DeptResp;
import com.zxh.manage.resp.Resp;
import com.zxh.manage.resp.UserResp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxh
 * @create 2021-12-02-14:57
 * @statement
 */

public interface IDeptService {
    /**
     * 获取所有部门信息
     * @return
     * @param deptName deptNo
     aram userMobile
     */
    List<DeptResp> getList(String deptName, String deptNo);

    /**
     * 获取部门记录数量
     */
    int getCount();

    /**
     * 添加新部门
     * @param dept
     * @return
     */
    int insert(Dept dept);

    /**
     * 编辑部门信息
     * @param dept
     * @return
     */
    int update(Dept dept);

    /**
     * 删除部门
     * @param id
     * @return
     */
    int delete(Long id);
}
