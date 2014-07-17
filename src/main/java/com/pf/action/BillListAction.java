package com.pf.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pf.model.entity.TBill;
import com.pf.model.entity.TUser;
import com.pf.service.BillManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 13-12-27.
 */
@Component
public class BillListAction extends ActionSupport {
    @Autowired
    private BillManager billManager;
    private List<TBill> billList;

    public List<TBill> getBillList() {
        return billList;
    }

    public void setBillList(List<TBill> billList) {
        this.billList = billList;
    }

    public String execute(){
        HttpServletRequest request = ServletActionContext.getRequest();//得到HttpServletRequest对象
        HttpSession session = request.getSession();//得到HttpSession对象
        TUser user=(TUser)session.getAttribute("user");
        System.out.println("----------------------当前用户：" + user.getUserName() + "-------------------------");
        billList=this.billManager.listBill(user.getUserId());
        if (billList.size() > 0 || billList!=null) {
            return "success";
        } else{
            return "error";
        }
    }
}
