package com.example.mybatis.service;

import com.example.mybatis.entity.Gonggao;
import com.example.mybatis.entity.Xiaoshuo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GonggaoService {


   List<Gonggao> list(Map<String, Object> map);

   int remove(Integer id);

   int save(Gonggao gonggao);
}
