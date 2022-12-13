package com.example.mybatis.controller;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.entity.Gonggao;
import com.example.mybatis.entity.UserDO;
import com.example.mybatis.service.GonggaoService;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/android")
public class AndroidController {

    @Autowired
    private UserService userService;
    @Autowired
    private GonggaoService gonggaoService;


    private JSONObject objectTrue = new JSONObject();
    private JSONObject objectFalse = new JSONObject();
    private JSONObject objectname= new JSONObject();

    public AndroidController() throws JSONException {
        objectTrue.put("result", true);
        objectFalse.put("result", false);
    }

    @RequestMapping("/login")
    @ResponseBody
    public String androidlogin(@RequestParam("zhanghao") String zhanghao,
                                     @RequestParam("password") String password){

        System.out.println("账号：" + zhanghao + ", 密码: " + password);

      UserDO user=userService.loginService(zhanghao,password);
        if(user==null){
            System.out.println("登入失败");
      return       objectFalse.toString();
        }
        else {
            System.out.println("登入成功");
            return objectTrue.toString();
        }

    }


    @RequestMapping("/register")
    @ResponseBody
    public String androidregister(@RequestParam("username") String username,
                               @RequestParam("password") String password,@RequestParam("zhanghao") String zhanghao){

        System.out.println("注册昵称：" + username + ", 注册密码: " + password+",注册账号" +zhanghao);

        UserDO user=new UserDO();
        user.setZhanghao(zhanghao);
        user.setUser_name(username);
        user.setPassword(password);
        try {
            userService.save(user);
            return objectTrue.toString();
        }
      catch (Exception e){
            return objectFalse.toString();
      }


    }


    @RequestMapping("/fragment4")
    @ResponseBody
    public UserDO fragment4(@RequestParam("zhanghao") String zhanghao){

        System.out.println("账号" +zhanghao);
        if(null==zhanghao){
            return  null;
        }
        return userService.fragemnt4(zhanghao);

    }

    @RequestMapping("/kml")
    @ResponseBody
    public String gonggao2(@RequestParam("message") String message){
        // 插入数据
        System.out.println("dqwd");
        // 回传代码片段
        Gonggao gonggao=new Gonggao();
        gonggao.setContent(message);
        gonggao.setType("2");
        gonggaoService.save(gonggao);
        return "SFW";
    }



}
