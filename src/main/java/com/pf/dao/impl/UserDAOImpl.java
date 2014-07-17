package com.pf.dao.impl;

import com.pf.dao.UserDAO;
import com.pf.model.entity.TUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<TUser> implements UserDAO {
    /**
     * 通过用户名密码获取用户 DAO
     * @param userName
     * @param userPasswd
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TUser> getUserByNAP(String userName, String userPasswd) {

        Object values[] = { userName, userPasswd };
        System.out.println("查询的结果是：" + userName + "   " + userPasswd);
        return this.getHibernateTemplate().find(
                "from TUser u where u.userName=? and u.userPasswd=? order by id",
                values);
    }
    @Override
    public List<TUser> getUserByUserName(String userName) {

        Object values[] = { userName};
        System.out.println("查询的结果是：" + userName );
        return this.getHibernateTemplate().find(
                "from TUser u where u.userName=? order by id",
                values);
    }
}
