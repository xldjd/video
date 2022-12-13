package com.example.mybatis.repository;

import com.example.mybatis.entity.UserDO;
import com.example.mybatis.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface VideoDao {



    /**
     * 对应节点 select id="get" resultType="com.example.mybatis.repository.UserDO"
     * */
  Video get(Integer id);

    List<Video> list(Map<String, Object> map);

    int remove(Integer id);

    int updateAfter(@Param(value="id") Integer id);

    int save(Video video);

  int update(Video video);
}
