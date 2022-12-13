package com.example.mybatis.service;

import com.example.mybatis.entity.Manhua;
import com.example.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ManhuaService {

   Manhua get(Integer id);

   List<Manhua> list(Map<String, Object> map);

   int remove(Integer id);

   int updateAfter(@Param(value="id") Integer id);

   int save(Manhua manhua);

   int update(Manhua manhua);

}
