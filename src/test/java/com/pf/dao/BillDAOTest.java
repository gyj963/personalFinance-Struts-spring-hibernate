package com.pf.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pf.TestBase;
import com.pf.model.entity.TBill;
import com.pf.model.entity.TUser;
import com.pf.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Administrator on 13-12-27.
 */
public class BillDAOTest extends TestBase {
    @Autowired
    private BillDAO dao;
    @Autowired
    private BillManager billManager;
    private static final Log log = LogFactory.getLog(BillDAOTest.class);

    @Test
    public void testListBill() throws Exception {
//        List<TBill> tBills = dao.listBill(5);
//        for (TBill tBill : tBills) {
//            log.debug(tBill);
//        }
//        List<TBill> tBills=dao.filterByDate(new Date("2012-01-01"),new Date("2014-01-01"));
//        for (TBill tBill : tBills) {
//            log.debug(tBill);
//        }
//        List list=dao.statisByStyle(5);
//        for (Object o : list) {
//            System.out.println(o+"---------------------------------------------");
//        }
//        List list=dao.statisByMemo(5);
//        for (Object o : list) {
//            System.out.println(o+"---------------------------------------------");
//        }
//        List list1=dao.statisByCreatedTimeAndStyleIsIncome(5);
//        for (Object o : list1) {
//            System.out.println(o+"----------------收入按时间------------------------");
//
//        }
//        List list2=dao.statisByCreatedTimeAndStyleIsPay(5);
//        for (Object o : list2) {
//            System.out.println(o+"-------------------支出按时间--------------------");
//
//        }
        HttpServletRequest request = ServletActionContext.getRequest();//得到HttpServletRequest对象
        HttpServletResponse response = ServletActionContext.getResponse();//得到HttpServletRequest对象
        HttpSession session = request.getSession();//得到HttpSession对象
        TUser user=(TUser)session.getAttribute("user");
        List listPay=billManager.statisByCreatedTimeAndStyleIsPay(5);
        List listIncome=billManager.statisByCreatedTimeAndStyleIsIncome(5);

        List billStatis=new ArrayList();
        billStatis.add(listPay);
        billStatis.add(listIncome);

        ObjectMapper om=new ObjectMapper();
        String json=om.writeValueAsString(billStatis);
        System.out.println(json+"-----------json--------------------------");

//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        out.print(json);
//        out.flush();
//        out.close();
    }
}
