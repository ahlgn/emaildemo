package com.bb.emaildemo.model;

public class FriendsAndInfo {
    private Userinfo userinfo;
    private Friends friend;

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public Friends getFriend() {
        return friend;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public void setFriend(Friends friend) {
        this.friend = friend;
    }
}
