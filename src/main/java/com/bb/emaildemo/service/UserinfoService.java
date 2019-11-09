package com.bb.emaildemo.service;

import com.bb.emaildemo.model.User;
import com.bb.emaildemo.model.Userinfo;

public interface UserinfoService {
    Boolean updateInfo(Userinfo userinfo);
    Userinfo findUserinfo(User user);
}
