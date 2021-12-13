package com.zxh.manage.mapper;

import com.zxh.manage.pojo.Dept;
import com.zxh.manage.pojo.Role;
import com.zxh.manage.pojo.User;
import com.zxh.manage.resp.UserResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Map<String,Object> login(String userName, String password);

    List<UserResp> selectAll(@Param("userName") String userName, @Param("userMobile") String userMobile);

    int getCount();

    List<Role> selectRole();

    List<Dept> selectDept();
}