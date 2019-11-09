package com.bb.emaildemo.serivceImp;

import com.bb.emaildemo.dao.FriendsMapper;
import com.bb.emaildemo.dao.UserMapper;
import com.bb.emaildemo.dao.UserinfoMapper;
import com.bb.emaildemo.model.*;
import com.bb.emaildemo.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class FriendsServiceImp implements FriendsService {

    @Autowired
    private FriendsMapper friendsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private UserinfoServiceImp userinfoServiceImp;

    @Override
    public List<FriendsAndInfo> findAllFriends(User user) {
        FriendsAndInfo friendsAndInfo;
        FriendsExample example = new FriendsExample();
        example.setOrderByClause("f_remark desc");
        FriendsExample.Criteria criteria = example.createCriteria();
        criteria.andFUserEqualTo(user.getuId());
        List<Friends> friends=friendsMapper.selectByExample(example);
        List<FriendsAndInfo> friendsAndInfos=new ArrayList<>();
        if(friends.size()!=0){
            System.out.println(friends.size()+"YYYYYYYYYYYyyy");

            for(Friends friend : friends){
                //获取info
                friendsAndInfo = new FriendsAndInfo();
                User user2 = new User();
                user.setuId(friend.getfFriend());
                Userinfo userinfo=userinfoServiceImp.findUserinfo(user);
                System.out.println(userinfo.getInfoRemark());
                friendsAndInfo.setUserinfo(userinfo);
                friendsAndInfo.setFriend(friend);
                friendsAndInfos.add(friendsAndInfo);
            }
        }else {
            friendsAndInfos=null;
        }


        return friendsAndInfos;
    }

    @Override
    public Boolean deleteFriend(User user, int fFriends) {

        try{
            FriendsExample example = new FriendsExample();
            FriendsExample.Criteria criteria =example.createCriteria();
            criteria.andFUserEqualTo(user.getuId());
            criteria.andFFriendEqualTo(fFriends);
            friendsMapper.deleteByExample(example);
            return true;
        }catch (Exception e){
            return  false;
        }

    }

    @Override
    public Boolean addFriend(Friends friends) {


        friends.setfCreatetime(new Date());
        //查询获得昵称
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria = example.createCriteria();
        criteria.andInfoUserEqualTo(friends.getfFriend());
        Userinfo userinfoFriends= userinfoMapper.selectByExample(example).get(0);
        friends.setfRemark(userinfoFriends.getInfoRemark());

        friendsMapper.insert(friends);
        return true;
    }

    @Override
    public Boolean updateFriend(Friends friends) {
        friendsMapper.updateByPrimaryKey(friends);
        return true;
    }

    @Override
    public List<FriendsAndInfo> findFriend(User user, String search) {
        FriendsExample example = new FriendsExample();
        FriendsExample.Criteria criteria =example.createCriteria();
        criteria.andFRemarkLike("%"+search+"%");
        /* FriendsExample.Criteria or=example.or();
        or.andFFriendEqualTo(Integer.parseInt(search));*/
         List<Friends> friends=friendsMapper.selectByExample(example);
        return null;
    }

    public Friends findfriend(int userId,int friendId){
        FriendsExample example = new FriendsExample();
        FriendsExample.Criteria criteria =example.createCriteria();
        System.out.println(userId+"--------------"+friendId);
        criteria.andFFriendEqualTo(friendId);
        criteria.andFUserEqualTo(userId);

        System.out.println(friendsMapper.selectByExample(example).size()+"44444444444");
        if (friendsMapper.selectByExample(example).size()==1){
            Friends friend=friendsMapper.selectByExample(example).get(0);
            return friend;
        }else {
            return null;
        }
    }

}
