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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 13-12-27.
 */
@Component
public class BillFilterAction extends ActionSupport {
    @Autowired
    private BillManager billManager;
    private List<TBill> billList;
    private String minDate;
    private String maxDate;

    public List<TBill> getBillList() {
        return billList;
    }

    public void setBillList(List<TBill> billList) {
        this.billList = billList;
    }

    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    @Override
    public String execute() throws Exception {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date minDateTmp = simpleDateFormat.parse(minDate);
            Date maxDateTmp = simpleDateFormat.parse(maxDate);
            HttpServletRequest request = ServletActionContext.getRequest();//得到HttpServletRequest对象
            HttpSession session = request.getSession();//得到HttpSession对象
            TUser user=(TUser)session.getAttribute("user");
            int userId=user.getUserId();
            billList=billManager.filterByDate(minDateTmp, maxDateTmp, userId);
            for (TBill tBill : billList) {
                   System.out.println(tBill.toString()+"---------------------------------------------");
            }
            request.setAttribute("billList",billList);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
