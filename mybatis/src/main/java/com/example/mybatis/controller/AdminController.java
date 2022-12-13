package com.example.mybatis.controller;

import com.example.mybatis.entity.*;
import com.example.mybatis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;


@Controller
@RequestMapping("/")
public class AdminController {


    @GetMapping("/user/zm")
    public String login(){
        return "main";
    }





    @RestController
    public class IndexController {

        @Autowired
        private UserService userService;

        @Autowired
        private XiaoshuoService xiaoshuoService;

        @Autowired
        private VideoService videoService;

        @Autowired
        private ManhuaService manhuaService;

        @Resource
        private GonggaoService gonggaoService;

//        @RequestMapping(value = "/gr") // 访问路径
//        public ModelAndView toIndex() {
//            // 返回templates目录下index.html
//            ModelAndView view = new ModelAndView("main");
//            // 查询所有的用户，添加到model视图里
//            view.addObject("user_list", userService.list(new HashMap<>()));
//            view.addObject("xiaoshuo_list",xiaoshuoService.list(new HashMap<>()));
//            view.addObject("video_list",videoService.list(new HashMap<>()));
//            view.addObject("manhua_list",manhuaService.list(new HashMap<>()));
//            return view;
//        }


        @GetMapping(value = "/user/select")
        public ModelAndView selectLike(String search) {
            ModelAndView view = new ModelAndView("main::userTable");
            view.addObject("user_list", userService.get(Integer.valueOf(search)));
            return view;
        }

        @GetMapping(value = "/user/select1")
        public ModelAndView selectLike1(String search) {
            ModelAndView view = new ModelAndView("main::xiaoshuo_Table");
            view.addObject("xiaoshuo_list", xiaoshuoService.get(Integer.valueOf(search)));
            return view;
        }

        @GetMapping(value = "/user/select2")
        public ModelAndView selectLike2(String search) {
            ModelAndView view = new ModelAndView("main::video_Table");
            view.addObject("video_list", videoService.get(Integer.valueOf(search)));
            return view;
        }
        @GetMapping(value = "/user/select3")
        public ModelAndView selectLike3(String search) {
            ModelAndView view = new ModelAndView("main::manhua_Table");
            view.addObject("manhua_list", manhuaService.get(Integer.valueOf(search)));
            return view;
        }

        @PostMapping(value = "/user/delete")
        public ModelAndView deleteUser(Integer id) {
            // 通过编号删除用户
            System.out.println(id);
            userService.remove(Integer.valueOf(id));
            userService.updateAfter(id);
            ModelAndView view = new ModelAndView("main::userTable");
            // 返回新的数据列表
            view.addObject("user_list", userService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/delete1")
        public ModelAndView deleteUser1(Integer id) {
            // 通过编号删除用户
            System.out.println(id);
           xiaoshuoService.remove(Integer.valueOf(id));
            xiaoshuoService.updateAfter(id);
            ModelAndView view = new ModelAndView("main::xiaoshuo_Table");
            // 返回新的数据列表
            view.addObject("xiaoshuo_list", xiaoshuoService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/delete2")
        public ModelAndView deleteUser2(Integer id) {
            // 通过编号删除用户
            System.out.println(id);
            videoService.remove(Integer.valueOf(id));
            videoService.updateAfter(id);
            ModelAndView view = new ModelAndView("main::video_Table");
            // 返回新的数据列表
            view.addObject("video_list", videoService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/delete3")
        public ModelAndView deleteUser3(Integer id) {
            // 通过编号删除用户
            System.out.println(id);
           manhuaService.remove(Integer.valueOf(id));
        manhuaService.updateAfter(id);
            ModelAndView view = new ModelAndView("main::manhua_Table");
            // 返回新的数据列表
            view.addObject("manhua_list", manhuaService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/delete4")
        public ModelAndView deleteUser4(Integer id) {
            // 通过编号删除用户
            System.out.println(id);
            gonggaoService.remove(Integer.valueOf(id));
            ModelAndView view = new ModelAndView("main::gongao_Table");
            view.addObject("gongdao_list",gonggaoService.list(new HashMap<>()));
            return view;
        }




        @PostMapping(value = "/user/insert")
        public ModelAndView insertUser(String username,String nickname,String  password) {
            // 插入数据
            UserDO user=new UserDO();
            user.setUser_name(nickname);
            user.setZhanghao(username);
            user.setPassword(password);
            userService.save(user);
            // 回传代码片段
            ModelAndView view = new ModelAndView("main::userTable");
            view.addObject("user_list", userService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/insert1")
        public ModelAndView insertUser1(String xiaoshuo_image,String title,String  content,String address) {
            // 插入数据
System.out.println(title);
            // 回传代码片段
            Xiaoshuo xiaoshuo=new Xiaoshuo();
            xiaoshuo.setXiaoshuo_image(xiaoshuo_image);
            xiaoshuo.setTitle(title);
            xiaoshuo.setContent(content);
            xiaoshuo.setAddress(address);
            xiaoshuoService.save(xiaoshuo);
            ModelAndView view = new ModelAndView("main::xiaoshuo_Table");
            view.addObject("xiaoshuo_list", xiaoshuoService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/insert2")
        public ModelAndView insertUser2(String video_name,String video_image,String  video_address) {
            // 插入数据
            System.out.println(video_name);
            // 回传代码片段
            Video video=new Video();
            video.setVideo_name(video_name);
            video.setVideo_image(video_image);
            video.setVideo_address(video_address);
            videoService.save(video);
            ModelAndView view = new ModelAndView("main::video_Table");
            view.addObject("video_list", videoService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/insert3")
        public ModelAndView insertUser3(String image_manhua,String title,String  content,String address) {
            // 插入数据
            System.out.println(title);
            // 回传代码片段
            Manhua manhua =new Manhua();
            manhua.setImage_manhua(image_manhua);
            manhua.setTitle(title);
            manhua.setContent(content);
            manhua.setAddress(address);
            manhuaService.save(manhua);
            ModelAndView view = new ModelAndView("main::xiaoshuo_Table");
            view.addObject("manhua_list", manhuaService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/insert4")
        public ModelAndView insertUser4(String content) {
            // 插入数据
            System.out.println(content);
            // 回传代码片段
      Gonggao gonggao=new Gonggao();
      gonggao.setContent(content);
      gonggao.setType("1");
      gonggaoService.save(gonggao);
            ModelAndView view = new ModelAndView("main::gongao_Table");
            view.addObject("gongdao_list",gonggaoService.list(new HashMap<>()));
            return view;
        }



        @PostMapping(value = "/user/update")
        public ModelAndView updateUser(String id, String username,String nickname,String  password,String sex) {

            UserDO user=new UserDO();
            user.setId(Integer.valueOf(id));
            user.setSex(Integer.valueOf(sex));
            user.setUser_name(nickname);
            user.setZhanghao(username);
            user.setPassword(password);
            userService.update(user);
            ModelAndView view = new ModelAndView("main::userTable");
            view.addObject("user_list", userService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/update1")
        public ModelAndView updateUser1(String id, String xiaoshuo_image,String title,String  content,String address) {

           System.out.println(id);
           Xiaoshuo xiaoshuo=new Xiaoshuo();
           xiaoshuo.setId(Integer.valueOf(id));
           xiaoshuo.setXiaoshuo_image(xiaoshuo_image);
           xiaoshuo.setTitle(title);
           xiaoshuo.setContent(content);
           xiaoshuo.setAddress(address);
           xiaoshuoService.update(xiaoshuo);
            ModelAndView view = new ModelAndView("main::xiaoshuo_Table");
            view.addObject("xiaoshuo_list", xiaoshuoService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/update2")
        public ModelAndView updateUser2(String id,String video_name,String video_image,String  video_address) {


            System.out.println(id);
            Video video=new Video();
            video.setId(Integer.valueOf(id));
            video.setVideo_name(video_name);
            video.setVideo_image(video_image);
            video.setVideo_address(video_address);
            videoService.update(video);
            ModelAndView view = new ModelAndView("main::video_Table");
            view.addObject("video_list",videoService.list(new HashMap<>()));
            return view;
        }

        @PostMapping(value = "/user/update3")
        public ModelAndView updateUser3(String id,String image_manhua,String title,String  content,String address) {

            System.out.println(id);
            Manhua manhua=new Manhua();
            manhua.setId(Integer.valueOf(id));
            manhua.setImage_manhua(image_manhua);
            manhua.setTitle(title);
            manhua.setContent(content);
            manhua.setAddress(address);
            manhuaService.update(manhua);
            ModelAndView view = new ModelAndView("main::manhua_Table");
            view.addObject("manhua_list",manhuaService.list(new HashMap<>()));
            return view;
        }



    }


    @Controller
    @RequestMapping("/user")
    public class myusercontroller {

        @Resource
        private AdminService adminService;

        @Resource
        private UserService userService;
        @Resource
        private XiaoshuoService xiaoshuoService;
        @Resource
        private VideoService videoService;
        @Resource
        private ManhuaService manhuaService;
        @Resource
        private GonggaoService gonggaoService;

        @RequestMapping(value = "zm",method = RequestMethod.POST)
        public ModelAndView getLoginCl(@RequestParam("name") String username, @RequestParam("password") String password){
            Admin user=adminService.loginService(username,password);
            ModelAndView view = new ModelAndView("main");
            // 查询所有的用户，添加到model视图里
            view.addObject("user_list", userService.list(new HashMap<>()));
            view.addObject("xiaoshuo_list",xiaoshuoService.list(new HashMap<>()));
            view.addObject("video_list",videoService.list(new HashMap<>()));
            view.addObject("manhua_list",manhuaService.list(new HashMap<>()));
            view.addObject("gongdao_list",gonggaoService.list(new HashMap<>()));
            if(user!=null){
                return view;
            }else{
                ModelAndView view2 = new ModelAndView("error");
       return view2;
            }

        }







    }


}

