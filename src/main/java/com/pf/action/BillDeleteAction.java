package com.pf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pf.service.BillManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 13-12-27.
 */
@Component
public class BillDeleteAction extends ActionSupport {
    @Autowired
    private BillManager billManager;

    @Override
    public String execute() throws Exception {
         try{
            HttpServletRequest request = ServletActionContext.getRequest();
            int billId=Integer.parseInt(request.getParameter("billId"));
            billManager.deleteBillById(billId);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
