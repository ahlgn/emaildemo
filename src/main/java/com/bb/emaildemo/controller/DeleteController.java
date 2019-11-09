package com.bb.emaildemo.controller;

import com.bb.emaildemo.dao.EmailMapper;
import com.bb.emaildemo.model.EmailAndUserinfo;
import com.bb.emaildemo.serivceImp.EmailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeleteController {

    @Autowired
    EmailServiceImp emailServiceImp;
    @Autowired
    EmailMapper emailMapper;

    @RequestMapping(value = ("/deleteemail/{id}"))
    public String sends(@PathVariable int id, Model model){
        List<EmailAndUserinfo> emailAndUserinfos =emailServiceImp.getallDelete(id);
        model.addAttribute("emailAndUserinfos",emailAndUserinfos);
        return "delete";

    }

    @RequestMapping( value=("/resume/{id}") )
    public String resume(@PathVariable int id){
        emailServiceImp.setDeleteEmail(id);
        int uid=emailMapper.selectByPrimaryKey(id).geteSendpeople();
        return "redirect:/deleteemail/"+uid;
    }
}
