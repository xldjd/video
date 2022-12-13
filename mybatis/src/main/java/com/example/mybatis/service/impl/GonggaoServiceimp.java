package com.example.mybatis.service.impl;

import com.example.mybatis.entity.Gonggao;
import com.example.mybatis.repository.AdminDao;
import com.example.mybatis.repository.GonggaoDao;
import com.example.mybatis.service.GonggaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GonggaoServiceimp implements GonggaoService {


    @Autowired
    public GonggaoDao gonggaoDao;



    @Override
    public List<Gonggao> list(Map<String, Object> map) {
        return gonggaoDao.list(map);
    }

    @Override
    public int remove(Integer id) {
        return gonggaoDao.remove(id);
    }

    @Override
    public int save(Gonggao gonggao) {
        return gonggaoDao.save(gonggao);
    }


}
