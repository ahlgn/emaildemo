package com.bb.emaildemo.controller;

import com.bb.emaildemo.model.Email;
import com.bb.emaildemo.serivceImp.EmailServiceImp;
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
public class WriteController {
    //创建文件所需要的存放路径

    @Value("${cbs.imagesPath}")
    private String theSetDir; //全局配置文件中设置的图片的路径

    public HttpServletRequest requestpath;
    /*  public static final FileSystemResource DATA_DIR=new FileSystemResource("/upload");*/
    @Autowired
    EmailServiceImp emailServiceImp;

    @RequestMapping(value = "/writeemail/{id}/{fid}")
    public String writeView(@PathVariable int id, @PathVariable int fid,Model model) {
        //获取session对象
        /*HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        User user=(User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);*/
        model.addAttribute("uid", id);
        model.addAttribute("fid",fid);

        return "writeemail";
    }


    @RequestMapping(value = "/writeupload", method = RequestMethod.POST)
    public String writeUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Email email) throws Exception {
        //方法一
        System.out.println(email.geteTheme());
        //如果文件不为空写入上传路径
        if (!file.isEmpty()) {
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
            email.seteFileurl(filename);
            emailServiceImp.sendEmail(email);

        } else {
            emailServiceImp.sendEmail(email);

        }
        return "redirect:/send/"+email.geteSendpeople();
    }

    //方法二
/*
        String fileName = file.getOriginalFilename();
        String path=request.getServletContext().getRealPath("/upload");
        FileSystemResource DATA_DIR=new FileSystemResource(path);

        //创建新的文件前缀后缀文件路径
        System.out.println(path+"+++++++++++++++");
        File tempFile = File.createTempFile("data"+(new Date()),getFileExtension(fileName) , DATA_DIR.getFile());

        try (InputStream in=file.getInputStream();
             OutputStream out=new FileOutputStream(tempFile)
        ){
            IOUtils.copy(in,out);
        }
        return "";*/


    private static String getFileExtension(String name){
        //获取文件呢名后缀
        return name.substring(name.lastIndexOf("."));

    }
}
