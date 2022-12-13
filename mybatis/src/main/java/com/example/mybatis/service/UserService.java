package com.example.mybatis.service;



import com.example.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserService {

    UserDO get(Integer id);

    List<UserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserDO user);

    int update(UserDO user);

    int remove(Integer id);


    int updateAfter(@Param(value="id") Integer id);

    int batchRemove(Integer[] ids);

  UserDO loginService(String username, String password);

    UserDO fragemnt4(String zhanghao);
}
