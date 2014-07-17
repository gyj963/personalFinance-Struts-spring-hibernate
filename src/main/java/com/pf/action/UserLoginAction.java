package com.pf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pf.model.entity.TUser;
import com.pf.service.UserManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 13-12-27.
 */
@Component
public class UserLoginAction extends ActionSupport{
    @Autowired
    private UserManager userManager;
    private String userName;
    private String userPasswd;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();//得到HttpServletRequest对象
        HttpSession session = request.getSession();//得到HttpSession对象

        List<TUser> userList=userManager.getUserByNAP(this.userName, this.userPasswd);
        if(userList.size()>0){
            TUser user=userList.get(0);
            session.setAttribute("user", user);
            return "success";
        }else{
            errorMessage="用户名或密码错误";
            return "error";
        }
    }
}
