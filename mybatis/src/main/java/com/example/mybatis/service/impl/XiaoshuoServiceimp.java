package com.example.mybatis.service.impl;



import com.example.mybatis.entity.Xiaoshuo;
import com.example.mybatis.repository.XiaoshuoDao;
import com.example.mybatis.service.VideoService;
import com.example.mybatis.service.XiaoshuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class XiaoshuoServiceimp implements XiaoshuoService {

    @Autowired
    public XiaoshuoDao xiaoshuoDao;


    public Xiaoshuo get(Integer id){
        return xiaoshuoDao.get(id);
    }

    public List<Xiaoshuo> list(Map<String, Object> map){
        return xiaoshuoDao.list(map);
    }

    @Override
    public int remove(Integer id) {
        return xiaoshuoDao.remove(id);
    }

    @Override
    public int updateAfter(Integer id) {
        return xiaoshuoDao.updateAfter(id);
    }

    @Override
    public int save(Xiaoshuo xiaoshuo) {
        return xiaoshuoDao.save(xiaoshuo);
    }

    @Override
    public int update(Xiaoshuo xiaoshuo) {
        return xiaoshuoDao.update(xiaoshuo);
    }
}
