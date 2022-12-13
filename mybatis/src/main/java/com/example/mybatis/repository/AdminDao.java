package com.example.mybatis.repository;

import com.example.mybatis.entity.Admin;
import com.example.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {

    Admin login(String username, String password);
}
