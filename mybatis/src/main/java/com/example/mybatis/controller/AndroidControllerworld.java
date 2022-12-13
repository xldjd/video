package com.example.mybatis.controller;


import com.example.mybatis.entity.Gonggao;
import com.example.mybatis.entity.Video;
import com.example.mybatis.service.GonggaoService;
import com.example.mybatis.service.ManhuaService;
import com.example.mybatis.service.VideoService;
import com.example.mybatis.service.XiaoshuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/android/world")
public class AndroidControllerworld {

    @Autowired
    private VideoService videoService;

    @Autowired
    private ManhuaService manhuaService;

    @Autowired
    private XiaoshuoService xiaoshuoService;

    @Autowired
    private GonggaoService gonggaoService;


    @RequestMapping("/video")
    @ResponseBody
    public Video androidlogin(@RequestParam("id") String id ){
        System.out.println(id);
        if(null==id){
            return  null;
        }
        return videoService.get(Integer.valueOf(id));
    }

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     * */
    @GetMapping("/users")
    @ResponseBody
    public Object getUsers(){

        return videoService.list(new HashMap<>());
    }

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     * */
    @GetMapping("/imgae")
    @ResponseBody
    public Object getUsers2(){

        return manhuaService.list(new HashMap<>());
    }

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     * */
    @GetMapping("/xiaoshuo")
    @ResponseBody
    public Object getUsers3(){

        return xiaoshuoService.list(new HashMap<>());
    }

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     * */
    @GetMapping("/gonggao")
    @ResponseBody
    public Object gonggao(){
        System.out.println("返回数据");
        return gonggaoService.list(new HashMap<>());
    }


}








