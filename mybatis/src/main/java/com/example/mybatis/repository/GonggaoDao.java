package com.example.mybatis.repository;


import com.example.mybatis.entity.Gonggao;
import com.example.mybatis.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GonggaoDao {

    List<Gonggao> list(Map<String, Object> map);

    int remove(Integer id);

    int save(Gonggao gonggao);
}
