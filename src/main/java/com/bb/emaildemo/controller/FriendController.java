package com.bb.emaildemo.controller;

import com.bb.emaildemo.dao.FriendsMapper;
import com.bb.emaildemo.model.Friends;
import com.bb.emaildemo.model.FriendsAndInfo;
import com.bb.emaildemo.model.User;
import com.bb.emaildemo.model.Userinfo;
import com.bb.emaildemo.serivceImp.FriendsServiceImp;
import com.bb.emaildemo.serivceImp.UserServiceImp;
import com.bb.emaildemo.serivceImp.UserinfoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FriendController {

    @Autowired
    UserinfoServiceImp userinfoServiceImp;

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    FriendsServiceImp friendsServiceImp;

    @Autowired
    FriendsMapper friendsMapper;

    @RequestMapping(value = "/addfriends/{id}")
    public String addFriendView(@PathVariable int id , Model model){

        User user=userServiceImp.getUser(id);
        Userinfo userinfo=new Userinfo();
        userinfo=null;
        model.addAttribute("user",user);
        model.addAttribute("userinfo",userinfo);
        return "addfriends";
    }

    @PostMapping(value = "/addfriendform")
    public  String addFriendFrom(@RequestParam("fId")int fId ,@RequestParam("uId")int uId,Model model){
        User user=userServiceImp.getUser(uId);
        User fuser=new User();
        fuser.setuId(fId);

        Userinfo userinfo=userinfoServiceImp.findUserinfo(fuser);
        model.addAttribute("user",user);
        model.addAttribute("userinfo",userinfo);
        return "addfriends";
    }

    @PostMapping(value = "/adduserAsay")
    @ResponseBody
    public Object addUserAsay(@RequestBody Friends friends){
        System.out.println(friends.getfFriend());
        Map<String,Boolean> map=new HashMap<>();
        Friends friend=friendsServiceImp.findfriend(friends.getfUser(),friends.getfFriend());
        if (friend!=null){
            map.put("status",false);
        }else {
            Boolean flag=friendsServiceImp.addFriend(friends);
            map.put("status",true);
        }

        System.out.println("%%%%%%%%%");
        System.out.println(map.get("status"));
        return map;
    }

    @RequestMapping(value = "/myfriends/{id}")
    public String myFriends(@PathVariable int id,Model model){
        User user = new User();
        user.setuId(id);
        List<FriendsAndInfo> friends =friendsServiceImp.findAllFriends(user);
        model.addAttribute("friends",friends);
        return "myfriends";
    }

    @RequestMapping(value = "/myfriendsitemview/{id}")
    public String myFriendsItem(@PathVariable int id,Model model){
        Friends friends1=friendsMapper.selectByPrimaryKey(id);
        model.addAttribute("friends",friends1);
        User user=new User();
        user.setuId(friends1.getfFriend());
        Userinfo userinfo=userinfoServiceImp.findUserinfo(user);
        model.addAttribute("userinfo",userinfo);

        return "myfriendsitem";
    }

    @RequestMapping(value = ("/updateremark/{id}/{fremark}"),method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
     public Object updateRemark(@PathVariable("id") int id,@PathVariable("fremark") String fremark){
        System.out.println(id+"-iiiiiiiiiiiiiiiiii-"+fremark);
        Friends friends=friendsMapper.selectByPrimaryKey(id);
        friends.setfRemark(fremark);
        friendsServiceImp.updateFriend(friends);
        Map<String,String> map=new HashMap<>();
        map.put("remark",fremark);
        return map;
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        int uid=friendsMapper.selectByPrimaryKey(id).getfUser();
        int i=friendsMapper.deleteByPrimaryKey(id);

        return "redirect:/myfriends/"+uid;
    }


}
