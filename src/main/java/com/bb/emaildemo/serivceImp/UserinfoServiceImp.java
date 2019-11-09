package com.bb.emaildemo.serivceImp;

import com.bb.emaildemo.dao.UserinfoMapper;
import com.bb.emaildemo.model.User;
import com.bb.emaildemo.model.Userinfo;
import com.bb.emaildemo.model.UserinfoExample;
import com.bb.emaildemo.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImp implements UserinfoService {

   @Autowired
    UserinfoMapper userinfoMapper;
    @Override
    public Boolean updateInfo(Userinfo userinfo) {
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria=example.createCriteria();
        System.out.println(userinfo.getInfoUser()+"$$$$$$$$$$");
        criteria.andInfoUserEqualTo(userinfo.getInfoUser());
        userinfoMapper.updateByPrimaryKey(userinfo);
        return true;
    }

    @Override
    public Userinfo findUserinfo(User user) {
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria=example.createCriteria();
        criteria.andInfoUserEqualTo(user.getuId());

        System.out.println( userinfoMapper.selectByExample(example).size()+"^^^^^^^^^^^^^");
       if (userinfoMapper.selectByExample(example).size()==0){
           return null;
       }else {
           Userinfo userinfo = userinfoMapper.selectByExample(example).get(0);
           return userinfo;
       }

    }
}
