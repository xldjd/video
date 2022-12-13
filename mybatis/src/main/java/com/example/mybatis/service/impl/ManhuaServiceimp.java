package com.example.mybatis.service.impl;



import com.example.mybatis.entity.Manhua;
import com.example.mybatis.entity.Video;
import com.example.mybatis.repository.ManhuaDao;
import com.example.mybatis.repository.VideoDao;
import com.example.mybatis.service.ManhuaService;
import com.example.mybatis.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManhuaServiceimp implements ManhuaService {

    @Autowired
    public ManhuaDao manhuaDao;


    public Manhua get(Integer id){
        return manhuaDao.get(id);
    }

    public List<Manhua> list(Map<String, Object> map){
        return manhuaDao.list(map);
    }

    @Override
    public int remove(Integer id) {
        return manhuaDao.remove(id);
    }

    @Override
    public int updateAfter(Integer id) {
        return manhuaDao.updateAfter(id);
    }

    @Override
    public int save(Manhua manhua) {
        return manhuaDao.save(manhua);
    }

    @Override
    public int update(Manhua manhua) {
        return manhuaDao.update(manhua);
    }
}
