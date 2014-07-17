package com.pf.service.impl;

import com.pf.dao.UserDAO;
import com.pf.model.entity.TUser;
import com.pf.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDAO userDAO;

//    private TBill tBill;
    @Override
    public void addUser(TUser tuser){
        userDAO.save(tuser);
    }

    /**
     * 通过用户名密码获取用户的Manager
     *
     * @param userName
     * @param userPasswd
     * @return
     */
    @Override
    public List<TUser> getUserByNAP(String userName, String userPasswd) {
          return userDAO.getUserByNAP(userName,userPasswd);
    }
    @Override
    public List<TUser> getUserByUserName(String userName) {
          return userDAO.getUserByUserName(userName);
    }


}
