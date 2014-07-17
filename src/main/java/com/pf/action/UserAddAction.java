package com.pf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pf.model.entity.TUser;
import com.pf.service.UserManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
@Component
public class UserAddAction extends ActionSupport {
    @Autowired
    UserManager userManager;
    TUser user;
    String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    // action
    public String execute() {		//处理用户请求
        HttpServletRequest request = ServletActionContext.getRequest();//得到HttpServletRequest对象
        HttpSession session = request.getSession();//得到HttpSession对象
        List<TUser> userList=userManager.getUserByUserName(this.user.getUserName());
        if (this.user.getUserName()==null||this.user.getUserPasswd()==null||this.user ==null){
            return "input";
        }else if(userList.size()>0){
            if(userList.get(0).getUserName().equals(this.user.getUserName())){
                errorMessage="该用户名已存在";
                return "error";
            }
            return  null;
        }else {
            this.userManager.addUser(this.user);
            session.setAttribute("user", user);
            return "success";
        }
    }
}
