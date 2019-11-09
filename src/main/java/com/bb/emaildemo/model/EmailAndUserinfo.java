package com.bb.emaildemo.model;

public class EmailAndUserinfo {
   private Email email;
   private Userinfo userinfo;
   private Friends friends;
   
    public void setEmail(Email email) {
        this.email = email;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public Email getEmail() {
        return email;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setFriends(Friends friends) {
        this.friends = friends;
    }

    public Friends getFriends() {
        return friends;
    }
}
