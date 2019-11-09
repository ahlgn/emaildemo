package com.bb.emaildemo.controller;


import com.bb.emaildemo.model.User;
import com.bb.emaildemo.model.Userinfo;
import com.bb.emaildemo.serivceImp.UserinfoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MyselfController {

    @Autowired
    UserinfoServiceImp userinfoServiceImp;


    @Value("${cbs.imagesPath}")
    private String theSetDir; //全局配置文件中设置的图片的路径


    @RequestMapping(value = "/myself/{id}")
    public String myself(@PathVariable int id, Model model){

        User user = new User();
        user.setuId(id);
        Userinfo userinfo =userinfoServiceImp.findUserinfo(user);
        model.addAttribute("userinfo",userinfo);
        return "myself";
    }
    @RequestMapping(value = "/myselfupload" ,method = RequestMethod.POST)
    public String myselfUpdate(HttpServletRequest request, @RequestParam("file") MultipartFile file,Userinfo userinfo)throws  Exception{
        User user = new User();
        user.setuId(userinfo.getInfoUser());
        Userinfo oldUserInfo=userinfoServiceImp.findUserinfo(user);
        //方法一
        System.out.println(userinfo.getInfoRemark()+userinfo.getInfoSex()+"%%%%%%%%%%%%");
        //如果文件不为空写入上传路径
        if (!file.isEmpty()&&isImage(file.getOriginalFilename())) {
            /*String path = request.getServletContext().getRealPath("/upload/");*/
            String path = theSetDir.substring(theSetDir.indexOf(':')+1, theSetDir.length()); //通过设置的那个字符串获得存放图片的目录路径

            System.out.println(path);
            System.out.println("++++++++++++++");
            SimpleDateFormat formatdata = new SimpleDateFormat("YYYYMMddHHmmss");
            Date date=new Date();
            String iddata=formatdata.format(date);
            String filename = iddata+file.getOriginalFilename();
            System.out.println(filename);
            File filepath = new File(path, filename);
            //判断路径是否存在不存在就创建一个路径
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存在目标文档中

            File file1 = new File(path + File.separator + filename);
            System.out.println("++++++++++++++");
            System.out.println(file1.getPath());
            file.transferTo(new File(path+File.separator+filename));
            userinfo.setInfoHeadimg(filename);
            userinfoServiceImp.updateInfo(userinfo);

        } else {
            userinfo.setInfoHeadimg(oldUserInfo.getInfoHeadimg());
            userinfoServiceImp.updateInfo(userinfo);
          }
        return "redirect:/myself/"+userinfo.getInfoUser();
    }

    private boolean isImage(String fileName){
        String suffix="abc";
        System.out.println(fileName.lastIndexOf('.')+"--------"+fileName.length());
        suffix=fileName.substring(fileName.lastIndexOf('.')+1,fileName.length());
        System.out.println(suffix);
        if(suffix.equals("jpg")||suffix.equals("png")){
            return true;
        }

       return false;
    }


}
