package com.example.mybatis.service.impl;



import com.example.mybatis.entity.Video;
import com.example.mybatis.repository.VideoDao;
import com.example.mybatis.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VideoServiceimp implements VideoService {

    @Autowired
    public VideoDao videoDao;


    public Video get(Integer id){
        return videoDao.get(id);
    }

    public List<Video> list(Map<String, Object> map){
        return videoDao.list(map);
    }

    @Override
    public int remove(Integer id) {
        return videoDao.remove(id);
    }

    @Override
    public int updateAfter(Integer id) {
        return videoDao.updateAfter(id);
    }

    @Override
    public int save(Video video) {
        return videoDao.save(video);
    }

    @Override
    public int update(Video video) {
        return videoDao.update(video);
    }
}
