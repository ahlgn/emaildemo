package com.bb.emaildemo.controller;

import com.bb.emaildemo.model.EmailAndUserinfo;
import com.bb.emaildemo.serivceImp.EmailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Value("${cbs.packagePath}")
    private String land;

    @Autowired
    EmailServiceImp emailServiceImp;
    @RequestMapping(value = "/received/{id}")
    public String receive(@PathVariable int id, Model model){
         List<EmailAndUserinfo> emailAndUserinfos =emailServiceImp.getAllReceiveEmailUserinfo(id);
        model.addAttribute("emailAndUserinfos",emailAndUserinfos);
        return "receive";
    }

    @RequestMapping(value = "/noreadreceived")
    public String noReadReceive( Model model) {
        System.out.println("noreceive");

        return "receive";
    }

    @RequestMapping(value = "/send/{id}")
    public String sends(@PathVariable int id, Model model){
        List<EmailAndUserinfo> emailAndUserinfos =emailServiceImp.getAllsendEmailUserinfo(id);
        model.addAttribute("emailAndUserinfos",emailAndUserinfos);
        return "send";

    }

    @RequestMapping(value = "/updateinfo/{id}")
    @ResponseBody
    public Object updatenoreadinfo(@PathVariable int id){
        int num= emailServiceImp.getAllReceiveEmailAndUnReaded(id).size();
        Map<String,Object> mp=new HashMap<>();
        mp.put("num",num);
        return mp;
    }

    @RequestMapping(value = "/downland/{name}" ,method = RequestMethod.GET)
        public void downloadFile1(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) throws IOException {

           String path=land+name;
         /*  String  path="D:/images/20190423163258t01acc71e1e343e5f1a.jpg";*/
           System.out.println(path);
           File file=new File(path);
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
        if (file.exists()){
            byte[] buffer=new byte[1024];//创建缓冲区
            FileInputStream fis=null;
            BufferedInputStream bis=null;

            fis=new FileInputStream(file);
            bis=new BufferedInputStream(fis);

            OutputStream os=response.getOutputStream();

            int i=bis.read(buffer);

            while (i!=-1){
                os.write(buffer,0,i);
                i=bis.read(buffer);

            }

            fis.close();
            bis.close();
            os.close();
            System.out.println("success");
           }else {
            System.out.println("fail");

        }

    }

}
