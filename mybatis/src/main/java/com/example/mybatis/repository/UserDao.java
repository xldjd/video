package com.example.mybatis.repository;


import com.example.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {


    /**
     * 对应节点 select id="get" resultType="com.fishpro.mybatis.domain.UserDO"
     * */
    UserDO get(Integer id);
    /**
     * 对应节点 select id="list" resultType="com.fishpro.mybatis.domain.UserDO"
     * */
    List<UserDO> list(Map<String, Object> map);
    /**
     * 对应节点 select id="count" resultType="int"
     * */
    int count(Map<String, Object> map);
    /**
     * 对应节点 insert id="save" parameterType="com.fishpro.mybatis.domain.UserDO" useGeneratedKeys="true" keyProperty="id"
     * */
    int save(UserDO user);
    /**
     * 对应节点 update id="update" parameterType="com.fishpro.mybatis.domain.UserDO"
     * */
    int update(UserDO user);
    /**
     * 对应节点 delete id="remove"
     * */
    int remove(Integer id);

    int updateAfter(@Param(value="id") Integer id);

    /**
     * 对应节点 delete id="batchRemove"
     * */
    int batchRemove(Integer[] ids);

    UserDO login(String zhanghao,String password);

    UserDO fragment4(String zhanghao);
}
