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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 13-12-27.
 */
@Component
public class BillUpdateAction extends ActionSupport{
    @Autowired
    private BillManager billManager;
    private int billId;
    private String billStyle;
    private BigDecimal billMoney;
    private String billCraetedTime;
    private String billMemo;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillStyle() {
        return billStyle;
    }

    public void setBillStyle(String billStyle) {
        this.billStyle = billStyle;
    }

    public BigDecimal getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(BigDecimal billMoney) {
        this.billMoney = billMoney;
    }

    public String getBillCraetedTime() {
        return billCraetedTime;
    }

    public void setBillCraetedTime(String billCraetedTime) {
        this.billCraetedTime = billCraetedTime;
    }

    public String getBillMemo() {
        return billMemo;
    }

    public void setBillMemo(String billMemo) {
        this.billMemo = billMemo;
    }

    @Override
    public String execute() throws Exception {
        try{
            HttpServletRequest request = ServletActionContext.getRequest();//得到HttpServletRequest对象
            HttpSession session = request.getSession();//得到HttpSession对象

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date craetedTime = simpleDateFormat.parse(billCraetedTime);

            TUser user=(TUser)session.getAttribute("user");

            TBill tBill=new TBill();
            tBill.setBillId(billId);
            tBill.setBillStyle(billStyle);
            tBill.setTUser(user);
            tBill.setBillMoney(billMoney);
            tBill.setBillCraetedTime(craetedTime);
            tBill.setBillMemo(billMemo);

            billManager.updateBill(tBill);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
