package com.star.getuser.dao;

import com.star.getuser.entity.User;
import com.star.getuser.entity.po.count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
//    List<User> getCreateTime();
    List<count> getCreateTime(@Param("timeRange") String timeRange);
//
    List<User> getAll();

}
