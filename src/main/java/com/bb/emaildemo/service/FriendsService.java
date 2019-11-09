package com.bb.emaildemo.service;

import com.bb.emaildemo.model.Friends;
import com.bb.emaildemo.model.FriendsAndInfo;
import com.bb.emaildemo.model.User;

import java.util.List;

public interface FriendsService {
    List<FriendsAndInfo> findAllFriends(User user);
    Boolean deleteFriend(User user, int fFriend);
    Boolean addFriend(Friends friends);
    Boolean updateFriend(Friends friends);
    List<FriendsAndInfo> findFriend(User user,String search);
}
