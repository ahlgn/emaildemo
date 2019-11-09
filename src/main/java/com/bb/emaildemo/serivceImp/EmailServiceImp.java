package com.bb.emaildemo.serivceImp;

import com.bb.emaildemo.dao.EmailMapper;
import com.bb.emaildemo.model.*;
import com.bb.emaildemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class EmailServiceImp implements EmailService {
    @Autowired
    private EmailMapper emailMapper;


    @Autowired
    private UserinfoServiceImp userinfoServiceImp;

    @Autowired
    private  FriendsServiceImp friendsServiceImp;

    @Override
    public Boolean sendEmail(Email email) {

        email.seteOrcollection("N");
        email.seteOrdelete("N");
        email.seteOrread("N");
        email.seteOrsend("Y");
        email.seteSendtime(new Date());
        email.seteOrcollection("N");
        emailMapper.insert(email);
        return true;
    }

    @Override
    public String setDeleteEmail(int eId) {
        Email email =emailMapper.selectByPrimaryKey(eId);
        String flog=email.geteOrdelete();

        if(flog.equals("Y")){
            email.seteOrdelete("N");
            flog="N";
        }else {
            email.seteOrdelete("Y");
            flog="Y";
        }
        emailMapper.updateByPrimaryKey(email);
        return flog;
    }

    @Override
    public Boolean SetReadEmail(int eId) {
        Email email =emailMapper.selectByPrimaryKey(eId);
        String flog=email.geteOrread();

        if(flog.equals("N")){
            email.seteOrread("Y");
        }
        emailMapper.updateByPrimaryKey(email);
        return true;
    }

    @Override
    public String SetCollection(int eId) {
        Email email =emailMapper.selectByPrimaryKey(eId);
        String flog=email.geteOrcollection();

       System.out.println(flog.equals("Y"));
        if(flog.equals("Y")){
            email.seteOrcollection("N");
            flog="N";
        }else{
            System.out.println("#########");
            email.seteOrcollection("Y");
            flog="Y";
        }
        emailMapper.updateByPrimaryKey(email);
        return flog;
    }

    @Override
    public List<Email> getAllSendEmail(int eSendPeople) {

        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andESendpeopleEqualTo(eSendPeople);

        List<Email> emails=emailMapper.selectByExample(example);

        return emails;
    }

    @Override
    public List<Email> getAllReceiveEmail(int eReceivePeople) {
        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(eReceivePeople);
        List<Email> emails=emailMapper.selectByExample(example);
        return emails;
    }

    @Override
    public List<EmailAndUserinfo> getAllReceiveEmailUserinfo(int eReceivePeople) {

       /*          构造搜索数据的条件约束                */
        EmailExample example = new EmailExample();
        example.setOrderByClause("e_sendtime desc");
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(eReceivePeople);
        criteria.andEOrdeleteEqualTo("N");

        /*                 查询符合条件的eamil                    */
        List<Email> emails=emailMapper.selectByExample(example);
        List<EmailAndUserinfo> emailAndUserinfos =new ArrayList<EmailAndUserinfo>();

        /*               根据id找到发件人                      */
        for(Email email:emails){
            System.out.println(email.geteTheme());
            User user=new User();
            user.setuId(email.geteSendpeople());
            /*获取userinfo*/
            Userinfo userinfo=userinfoServiceImp.findUserinfo(user);
            System.out.println(userinfo.getInfoRemark());
            EmailAndUserinfo  emailAndUserinfo=new EmailAndUserinfo();
            /*获取去friends*/
            Friends friends=friendsServiceImp.findfriend(eReceivePeople,email.geteSendpeople());

            if (friends!=null){
                System.out.println(friends.getfRemark());
                emailAndUserinfo.setFriends(friends);
            }
            emailAndUserinfo.setEmail(email);
            emailAndUserinfo.setUserinfo(userinfo);
            emailAndUserinfos.add(emailAndUserinfo);
        }
        return emailAndUserinfos;
    }

    @Override
    public List<EmailAndUserinfo> getAllReceiveCollectionEmailUserinfo(int eReceivePeople) {

        /*          构造搜索数据的条件约束                */
        EmailExample example = new EmailExample();
        example.setOrderByClause("e_sendtime desc");
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(eReceivePeople);
        criteria.andEOrcollectionEqualTo("Y");
        criteria.andEOrdeleteEqualTo("N");

        /*                 查询符合条件的eamil                    */
        List<Email> emails=emailMapper.selectByExample(example);
        List<EmailAndUserinfo> emailAndUserinfos =new ArrayList<EmailAndUserinfo>();

        /*               根据id找到发件人                      */
        for(Email email:emails){
            System.out.println(email.geteTheme());
            User user=new User();
            user.setuId(email.geteSendpeople());
            /*获取userinfo*/
            Userinfo userinfo=userinfoServiceImp.findUserinfo(user);
            System.out.println(userinfo.getInfoRemark());
            EmailAndUserinfo  emailAndUserinfo=new EmailAndUserinfo();
            /*获取friends*/
            Friends friends=friendsServiceImp.findfriend(eReceivePeople,email.geteSendpeople());

            if (friends!=null){
                System.out.println(friends.getfRemark());
                emailAndUserinfo.setFriends(friends);
            }
            emailAndUserinfo.setEmail(email);
            emailAndUserinfo.setUserinfo(userinfo);
            emailAndUserinfos.add(emailAndUserinfo);
        }
        return emailAndUserinfos;

    }

        @Override
    public List<EmailAndUserinfo> getAllsendEmailUserinfo(int eSendPeople) {

        /*          构造搜索数据的条件约束                */
        EmailExample example = new EmailExample();
        example.setOrderByClause("e_sendtime desc");
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andESendpeopleEqualTo(eSendPeople);

        /*                 查询符合条件的eamil                    */
        List<Email> emails=emailMapper.selectByExample(example);
        List<EmailAndUserinfo> emailAndUserinfos =new ArrayList<EmailAndUserinfo>();

        /*               根据id找到发件人                      */
        for(Email email:emails){
            User user=new User();
            user.setuId(email.geteReceive());
            /*获取userinfo*/
            Userinfo userinfo=userinfoServiceImp.findUserinfo(user);
            System.out.println(userinfo.getInfoRemark());
            EmailAndUserinfo  emailAndUserinfo=new EmailAndUserinfo();
            /*获取去friends*/
            Friends friends=friendsServiceImp.findfriend(eSendPeople,email.geteReceive());

            if (friends!=null){
                System.out.println(friends.getfRemark());
                emailAndUserinfo.setFriends(friends);
            }
            emailAndUserinfo.setEmail(email);
            emailAndUserinfo.setUserinfo(userinfo);
            emailAndUserinfos.add(emailAndUserinfo);
        }
        return emailAndUserinfos;
    }

    public List<EmailAndUserinfo> getallDelete(int id){
        /*          构造搜索数据的条件约束                */
        EmailExample example = new EmailExample();
        example.setOrderByClause("e_sendtime desc");
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(id);
        criteria.andEOrdeleteEqualTo("Y");

        /*                 查询符合条件的eamil                    */
        List<Email> emails=emailMapper.selectByExample(example);
        List<EmailAndUserinfo> emailAndUserinfos =new ArrayList<EmailAndUserinfo>();

        /*               根据id找到发件人                      */
        for(Email email:emails){
            System.out.println(email.geteTheme());
            User user=new User();
            user.setuId(email.geteSendpeople());
            /*获取userinfo*/
            Userinfo userinfo=userinfoServiceImp.findUserinfo(user);
            System.out.println(userinfo.getInfoRemark());
            EmailAndUserinfo  emailAndUserinfo=new EmailAndUserinfo();
            /*获取去friends*/
            Friends friends=friendsServiceImp.findfriend(id,email.geteSendpeople());

            if (friends!=null){
                System.out.println(friends.getfRemark());
                emailAndUserinfo.setFriends(friends);
            }
            emailAndUserinfo.setEmail(email);
            emailAndUserinfo.setUserinfo(userinfo);
            emailAndUserinfos.add(emailAndUserinfo);
        }
        return emailAndUserinfos;
    }

    @Override
    public Email getEmailById(int id) {
        Email email=emailMapper.selectByPrimaryKey(id);
        if(email.geteOrread().equals("N")){
            email.seteOrread("Y");
        }
        return email;
    }

    @Override
    public List<Email> getAllReceiveEmailAndReaded(int eReceivePeople) {
        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(eReceivePeople).andEOrreadLike("Y");
        List<Email> emails=emailMapper.selectByExample(example);
        return emails;
    }

    @Override
    public List<Email> getAllReceiveEmailAndUnReaded(int eReceivePeople) {
        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(eReceivePeople).andEOrreadLike("N");
        List<Email> emails=emailMapper.selectByExample(example);
        return emails;
    }

    @Override
    public List<Email> getAllDeleteEmail(int people) {
        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(people).andEOrdeleteLike("Y");
        EmailExample.Criteria or = example.or();
        or.andESendpeopleEqualTo(people).andEOrdeleteLike("Y");
        List<Email> emails=emailMapper.selectByExample(example);
        return emails;
    }

    @Override
    public List<Email> getAllCollectionEmail(int people) {
        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria=example.createCriteria();
        criteria.andEReceiveEqualTo(people).andEOrcollectionLike("Y");
        EmailExample.Criteria or = example.or();
        or.andESendpeopleEqualTo(people).andEOrcollectionLike("Y");
        List<Email> emails=emailMapper.selectByExample(example);
        return emails;
    }


}
