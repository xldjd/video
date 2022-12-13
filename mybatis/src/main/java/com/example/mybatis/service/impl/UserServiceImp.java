package com.example.mybatis.service.impl;



import com.example.mybatis.entity.UserDO;
import com.example.mybatis.repository.UserDao;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserDao userDao;


    public UserDO get(Integer id){
        return userDao.get(id);
    }


    public List<UserDO> list(Map<String, Object> map){
        return userDao.list(map);
    }


    public int count(Map<String, Object> map){
        return userDao.count(map);
    }


    public int save(UserDO user){
        return userDao.save(user);
    }


    public int update(UserDO user){
        return userDao.update(user);
    }


    public int remove(Integer id){
        return userDao.remove(id);
    }

    @Override
    public int updateAfter(Integer id) {
        return userDao.updateAfter(id);
    }


    public int batchRemove(Integer[] ids){
        return userDao.batchRemove(ids);
    }




    public UserDO loginService(String username, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
    return     userDao.login(username,password);
    }

    public UserDO fragemnt4(String zhanghao){
        return     userDao.fragment4(zhanghao);
    }

}


