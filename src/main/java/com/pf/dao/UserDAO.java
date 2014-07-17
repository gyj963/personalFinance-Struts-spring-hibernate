package com.pf.dao;

import com.pf.model.entity.TBill;
import com.pf.model.entity.TUser;

import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
public interface UserDAO extends BaseDAO<TUser> {
    public List<TUser> getUserByNAP(String userName, String userPasswd);

    List<TUser> getUserByUserName(String userName);
}
