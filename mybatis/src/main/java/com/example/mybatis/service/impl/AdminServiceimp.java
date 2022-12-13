package com.example.mybatis.service.impl;

import com.example.mybatis.entity.Admin;
import com.example.mybatis.repository.AdminDao;
import com.example.mybatis.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimp implements AdminService {

    @Autowired
    public AdminDao admindao;

    @Override
    public Admin loginService(String username, String password) {
        return admindao.login(username,password);
    }
}
