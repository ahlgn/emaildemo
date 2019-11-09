package com.bb.emaildemo;

import com.bb.emaildemo.model.*;
import com.bb.emaildemo.serivceImp.EmailServiceImp;
import com.bb.emaildemo.serivceImp.FriendsServiceImp;
import com.bb.emaildemo.serivceImp.UserServiceImp;
import com.bb.emaildemo.serivceImp.UserinfoServiceImp;
import com.bb.emaildemo.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(value = "com.bb.emaildemo.dao")
public class EmaildemoApplicationTests {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    FriendsServiceImp friendsServiceImp;

    @Autowired
    UserinfoServiceImp userinfoServiceImp;

    @Autowired
    EmailServiceImp emailServiceImp;
    @Test
    public void login() {
      /*  User user = new User();
        user.setuId(123456);
        user.setuPassword("tzg");
        User user2=userServiceImp.login(user);
        System.out.println(user2.getuCreatetime());*/
    }
   /* @Test
    public void regiest() {
        User user = new User();
        user.setuId(123431);
        user.setuPassword("12346");
        Boolean flog=userServiceImp.regiest(user);
        System.out.println(flog);
    }
    @Test
    public void changePasswd(){
        User user = new User();
        user.setuId(123467);
        user.setuPassword("12346");
        Boolean flog=userServiceImp.chagngePasswd(user,"tzg9609");
        System.out.println(flog);
    }
    *//*               --friendsinfo  -----------------------  *//*

    @Test
    public void findAllFriends(){
        User user = new User();
     *//*   user.setuId(123467);
        List<Friends> friends = friendsServiceImp.findAllFriends(user);
       for(Friends f : friends){
             System.out.println(f.getfRemark());
       }*//*

    }
    @Test
    public void  deleteFriends(){
        User user = new User();
        user.setuId(123467);
        Boolean flog=friendsServiceImp.deleteFriend(user,1234567);
        System.out.println(flog);
    }

    @Test
    public void addFriends(){
        User user = new User();
        user.setuId(123467);

    }
    @Test
    public void updateFriend(){
        Friends friends=new Friends();
        friends.setfId(2);
        friends.setfUser(123467);
        friends.setfFriend(1234568);
        friends.setfCreatetime(new Date());
        friends.setfRemark("汤正广");

        friendsServiceImp.updateFriend(friends);

    }

    @Test
    public  void findFriends(){
        User user = new User();
        user.setuId(123467);

       *//* List<Friends> friends=friendsServiceImp.findFriend(user,"芙");
        for(Friends f : friends){
            System.out.println(f.getfRemark());
        }*//*
    }

    *//* ------------------- 用户信息测试  ------------------     *//*

    @Test
    public void findUserinfo(){
        User user = new User();
        user.setuId(123467);
        Userinfo userinfo =userinfoServiceImp.findUserinfo(user);
        System.out.println(userinfo.getInfoRemark());
    }

    @Test
    public void  updateUserinfo(){
        Userinfo userinfo = new Userinfo();
        userinfo.setInfoId(2);
        userinfo.setInfoRemark("天明");
        userinfo.setInfoUser(123460);
        userinfo.setInfoHeadimg("upload/img");
        userinfo.setInfoSex("gentleman");
        userinfo.setInfoSign("走自己的路让别人无路可走");
        userinfoServiceImp.updateInfo(userinfo);
    }
*//* ----------------------短信发送测试------------------------------ *//*

    @Test
    public void sendEmail(){
        Email email = new Email();
        email.seteSendpeople(123456);
        email.seteReceive(654789);
        email.seteTheme("主题");
        email.seteContent("is发生大发发沙发斯蒂芬");
        email.seteFileurl("upload/img");

        emailServiceImp.sendEmail(email);
    }

    @Test
    public void orDelect(){
        emailServiceImp.setDeleteEmail(1);
    }

    @Test
    public  void orRead(){
        emailServiceImp.SetReadEmail(1);

    }

    @Test
    public void getAllsendemail(){
        List<Email> emails=emailServiceImp.getAllSendEmail(123456);
        Email email = emails.get(0);
         System.out.println(email.geteSendpeople());
    }
    @Test
    public void getAllreceiveemail(){
        List<EmailAndUserinfo> emails=emailServiceImp.getAllReceiveEmailUserinfo(999222);
        EmailAndUserinfo emailAndUserinfo = emails.get(0);
        System.out.println(emailAndUserinfo.getUserinfo().getInfoRemark());
    }
    @Test
    public void isRead(){
        List<Email> emails=emailServiceImp.getAllReceiveEmailAndReaded(654789);
        Email email = emails.get(0);
        System.out.println(email.geteSendpeople());
    }

    @Test
    public void getallConllection(){
        List<Email> emails=emailServiceImp.getAllCollectionEmail(654789);
        Email email = emails.get(0);
        System.out.println(email.geteSendpeople());
    }*/
}
