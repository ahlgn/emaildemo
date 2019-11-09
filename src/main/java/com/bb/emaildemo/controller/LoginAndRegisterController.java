package com.bb.emaildemo.controller;

import com.bb.emaildemo.model.User;
import com.bb.emaildemo.model.Userinfo;
import com.bb.emaildemo.serivceImp.EmailServiceImp;
import com.bb.emaildemo.serivceImp.FriendsServiceImp;
import com.bb.emaildemo.serivceImp.UserServiceImp;
import com.bb.emaildemo.serivceImp.UserinfoServiceImp;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginAndRegisterController {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    FriendsServiceImp friendsServiceImp;

    @Autowired
    UserinfoServiceImp userinfoServiceImp;

    @Autowired
    EmailServiceImp emailServiceImp;

    @RequestMapping("/login")
    public String loginView(){
        return "login";
    }

    @RequestMapping("/register")
    public String registerView(){
       return "register";
    }
//登录进入主界面
    @PostMapping("/loginmain")
    public String loginAction(
            User user,
            Model model, HttpSession session){

        User trUser=userServiceImp.login(user);
        System.out.println(user.getuId()+user.getuPassword());

        if(trUser!=null){
            System.out.println("success");
            Userinfo userInfo =userinfoServiceImp.findUserinfo(trUser);
            model.addAttribute("userInfo",userInfo);
            model.addAttribute("user",trUser);
            //创建session会话
            session.setAttribute("userInfo",userInfo);
            session.setAttribute("user",trUser);
            return "index";
        }else {
            System.out.println("error");
            return "login";
        }
    }

    @PostMapping("/adduser")
    public String addUser(User user){
       boolean b = userServiceImp.regiest(user);
       if(b){
           return "login";
       }else
       {
           return "register";
       }
    }

    @RequestMapping(value = "/registercheck" ,method = RequestMethod.POST)
    @ResponseBody  //返回数据是json数据
    public Object  registerCheck(@RequestBody User user){

        Assert.assertNotNull(user.getuId()+"","账号为空");
        Boolean flog=userServiceImp.regiestCheck(user);

        Map<String,Object> map = new HashMap<>();
        //返回的数据为真可以添加数据

       if (flog){
          map.put("status",true);
       }else {
           map.put("status",false);
       }
        return map;
    }



}
