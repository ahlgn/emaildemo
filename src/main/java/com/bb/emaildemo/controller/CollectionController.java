package com.bb.emaildemo.controller;

import com.bb.emaildemo.model.EmailAndUserinfo;
import com.bb.emaildemo.serivceImp.EmailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CollectionController {

    @Autowired
    EmailServiceImp emailServiceImp;
  @RequestMapping(value = "/collecctionview/{id}")
  public String ConnecctionView(@PathVariable int id, Model model){
      List<EmailAndUserinfo> emailAndUserinfos =emailServiceImp.getAllReceiveCollectionEmailUserinfo(id);
      model.addAttribute("emailAndUserinfos",emailAndUserinfos);
      return "receive";
  }

}
