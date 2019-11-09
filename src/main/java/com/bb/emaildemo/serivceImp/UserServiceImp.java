package com.bb.emaildemo.serivceImp;

import com.bb.emaildemo.dao.UserMapper;
import com.bb.emaildemo.dao.UserinfoMapper;
import com.bb.emaildemo.model.User;
import com.bb.emaildemo.model.UserExample;
import com.bb.emaildemo.model.Userinfo;
import com.bb.emaildemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Override
    public User login(User user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria  =example.createCriteria();
        criteria.andUIdEqualTo(user.getuId());
        String inputPasswd=user.getuPassword();

        List<User> users=userMapper.selectByExample(example);
        System.out.println(users.size());
        if(users.size()==0){return null;};
        user=users.get(0);
        System.out.println(users.get(0).getuId());
        String truePasswd=user.getuPassword();
        if(inputPasswd.equals(truePasswd)){
            return user;
        }else{
            return null;
        } }

    @Override
    public Boolean regiest(User user) {
        //验证账号是否存在
        UserExample example = new UserExample();
        User user2=userMapper.selectByPrimaryKey(user.getuId());
        if(user2==null){
            user.setuCreatetime(new Date());
            userMapper.insert(user);
            Userinfo userinfo=new Userinfo();
            userinfo.setInfoUser(user.getuId());
            userinfo.setInfoRemark(user.getuId()+"");
            userinfo.setInfoSex("gentleman");
            userinfo.setInfoHeadimg("head.jpg");
            userinfoMapper.insert(userinfo);
            return true;
        }
        return false;
    }
    public Boolean regiestCheck(User user){
        //验证账号是否存在
        UserExample example = new UserExample();
        UserExample.Criteria criteria  =example.createCriteria();
        criteria.andUIdEqualTo(user.getuId());
        List<User> users=userMapper.selectByExample(example);
        if (users.size()==1){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public Boolean chagngePasswd(User user, String newPassword) {
        //验证密码
        String inputPasswd=user.getuPassword();
        UserExample example = new UserExample();
        UserExample.Criteria criteria  =example.createCriteria();
        criteria.andUIdEqualTo(user.getuId());
        List<User> users=userMapper.selectByExample(example);
        user=users.get(0);
        String truePasswd=user.getuPassword();
        if(inputPasswd.trim().equals(truePasswd)){

            user.setuPassword(newPassword);
            userMapper.updateByPrimaryKey(user);
            return true;
        }
        return false;
    }

    public User getUser(int uid){
        //验证账号是否存在
        UserExample example = new UserExample();
        UserExample.Criteria criteria  =example.createCriteria();
        criteria.andUIdEqualTo(uid);
        List<User> users=userMapper.selectByExample(example);

        return users.get(0);
    }


}
