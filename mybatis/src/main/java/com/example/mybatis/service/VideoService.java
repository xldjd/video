package com.example.mybatis.service;

import com.example.mybatis.entity.UserDO;
import com.example.mybatis.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VideoService {

   Video get(Integer id);

   List<Video> list(Map<String, Object> map);


   int remove(Integer id);

   int updateAfter(@Param(value="id") Integer id);

   int save(Video video);

   int update(Video video);
}
