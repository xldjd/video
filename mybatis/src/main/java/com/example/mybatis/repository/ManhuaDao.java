package com.example.mybatis.repository;

import com.example.mybatis.entity.Manhua;
import com.example.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManhuaDao {



    /**
     * 对应节点 select id="get" resultType="com.example.mybatis.repository.UserDO"
     *
     * @return*/
  Manhua get(Integer id);

    List<Manhua> list(Map<String, Object> map);

    int remove(Integer id);

    int updateAfter(@Param(value="id") Integer id);

    int save(Manhua manhua);

  int update(Manhua manhua);
}
