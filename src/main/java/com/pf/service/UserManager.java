package com.pf.service;

import com.pf.model.entity.TUser;

import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
public interface UserManager {
    public void addUser(TUser tuser);

    List<TUser> getUserByNAP(String userName, String userPasswd);

    List<TUser> getUserByUserName(String userName);
}
