package com.example.mybatis.service;

import com.example.mybatis.entity.UserDO;
import com.example.mybatis.entity.Xiaoshuo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface XiaoshuoService {

  Xiaoshuo get(Integer id);

   List<Xiaoshuo> list(Map<String, Object> map);

    int remove(Integer id);

    int updateAfter(@Param(value="id") Integer id);

    int save(Xiaoshuo xiaoshuo);

    int update(Xiaoshuo xiaoshuo);

}
