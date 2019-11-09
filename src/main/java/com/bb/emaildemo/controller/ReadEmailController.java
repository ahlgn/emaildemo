package com.bb.emaildemo.controller;

import com.bb.emaildemo.dao.EmailMapper;
import com.bb.emaildemo.model.Email;
import com.bb.emaildemo.serivceImp.EmailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/reademail")
public class ReadEmailController {


    @Autowired
    EmailServiceImp emailServiceImp;
    @Autowired
    EmailMapper emailMapper;
    @RequestMapping(value = "/item/{id}")
    public String readEmailItem (@PathVariable int id , Model model){
        System.out.println(id);
       Email email = emailServiceImp.getEmailById(id);
       emailServiceImp.SetReadEmail(id);
       model.addAttribute("email",email);
       return "reademail";
    }

    @RequestMapping(value = "/itemsend/{id}")
    public String readsendEmailItem (@PathVariable int id , Model model){
        System.out.println(id);
        Email email = emailServiceImp.getEmailById(id);
        model.addAttribute("email",email);
        return "readsendemail";
    }

//书信收藏的
    @RequestMapping(value = "/itemconnection",method = RequestMethod.POST)
    @ResponseBody //设置返回的数据为json格式
    public Object OrConnectionEmail(@RequestBody Email email){

        int rId=email.geteId();
        System.out.println(rId);
        String flog=emailServiceImp.SetCollection(rId);
        Map<String,Object> map=new HashMap<>();

        if (flog.equals("Y")){
            map.put("status",true);
        }else{
            map.put("status",false);
        }
        System.out.println("%%%%%%%%%");
        System.out.println(map.get("status"));
        return map;
    }
// 删除书信
    @RequestMapping(value = "/itemdelete",method = RequestMethod.POST)
    @ResponseBody //设置返回的数据为json格式
    public Object itemDelete(@RequestBody Email email){

        int rId=email.geteId();
        System.out.println(rId);
        String flog=emailServiceImp.setDeleteEmail(rId);
        Map<String,Object> map=new HashMap<>();

        if (flog.equals("Y")){
            map.put("status",true);
        }else{
            map.put("status",false);
        }

        System.out.println(map.get("status"));
        return map;
    }


}
