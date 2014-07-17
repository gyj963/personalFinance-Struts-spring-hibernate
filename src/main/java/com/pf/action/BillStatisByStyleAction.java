package com.pf.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.pf.model.entity.TUser;
import com.pf.service.BillManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 13-12-28.
 */
@Component
public class BillStatisByStyleAction extends ActionSupport {
    @Autowired
    BillManager billManager;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();//得到HttpServletRequest对象
        HttpServletResponse response = ServletActionContext.getResponse();//得到HttpServletRequest对象
        HttpSession session = request.getSession();//得到HttpSession对象
        TUser user=(TUser)session.getAttribute("user");
        List list=billManager.statisByStyle(user.getUserId());

        ObjectMapper om=new ObjectMapper();
        String json=om.writeValueAsString(list);
        System.out.println(json+"-----------json--------------------------");

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
        return null;
    }
}
