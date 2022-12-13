package com.example.mybatis.repository;

import com.example.mybatis.entity.UserDO;
import com.example.mybatis.entity.Video;
import com.example.mybatis.entity.Xiaoshuo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface XiaoshuoDao {



    /**
     * 对应节点 select id="get" resultType="com.example.mybatis.repository.UserDO"
     * */
  Xiaoshuo get(Integer id);

    List<Xiaoshuo> list(Map<String, Object> map);

    int remove(Integer id);

    int updateAfter(@Param(value="id") Integer id);

    int save(Xiaoshuo xiaoshuo);

  int update(Xiaoshuo xiaoshuo);
}
