package com.zxh.manage.mapper;

import com.zxh.manage.pojo.Dept;
import com.zxh.manage.resp.DeptResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<DeptResp> selectAll(@Param("deptName")String deptName,@Param("deptNo")String deptNo);

    int getCount();
}