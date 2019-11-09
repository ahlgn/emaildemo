package com.bb.emaildemo.service;

import com.bb.emaildemo.model.User;

public interface UserService {
    User login(User user);
    Boolean regiest(User user);
    Boolean chagngePasswd(User user,String newPassword);

}
