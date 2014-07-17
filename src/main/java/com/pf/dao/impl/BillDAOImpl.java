package com.pf.dao.impl;

import com.pf.dao.BillDAO;
import com.pf.model.entity.TBill;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
@Repository
public class BillDAOImpl extends BaseDAOImpl<TBill> implements BillDAO {
    @SuppressWarnings("unchecked")

    public List<TBill> listBill(int userId) {

        Object values[] = {userId};
        System.out.println("查询的结果是：userId为" + userId + "的bill列表" );
        return this.getHibernateTemplate().find(
                "from TBill b where b.TUser.userId=? order by b.billId ",
                values);

    }
    @Override
    public List<TBill> filterByDate(Date minDate, Date maxDate, int userId) {
        System.out.println("查询的结果是：日期范围在" + minDate + "和"+maxDate+"的bill列表" );
        String hql="from TBill b where b.TUser.userId=? and b.billCraetedTime > ? and b.billCraetedTime < ?";
        Object values[] = {userId,minDate,maxDate};
        return this.getHibernateTemplate().find(hql,values);
    }

    @Override
    public List statisByStyle(int userId) {
        System.out.println("---------------------根据收支类型进行账单统计--------------------------");
        String hql="select new com.pf.model.vo.BillStyleStatis(b.billStyle,count (b.billStyle)) from TBill b where b.TUser.userId=? group by b.billStyle";
        Object values[] = {userId};
        return this.getHibernateTemplate().find(hql,values);
    }

    @Override
    public List statisByCreatedTimeAndStyleIsPay(int userId) {
        System.out.println("---------------------根据时间及类型进行账单统计--------------------------");
        String hql="select new com.pf.model.vo.BillCreatedTimeStatis(b.billCraetedTime,b.billMoney) from TBill b where b.TUser.userId=? and b.billStyle='支出' group by b.billCraetedTime";
        Object values[] = {userId};
        return this.getHibernateTemplate().find(hql,values);
    }
    @Override
    public List statisByCreatedTimeAndStyleIsIncome(int userId) {
        System.out.println("---------------------根据时间及类型进行账单统计--------------------------");
        String hql="select new com.pf.model.vo.BillCreatedTimeStatis(b.billCraetedTime,b.billMoney) from TBill b where b.TUser.userId=? and b.billStyle='收入' group by b.billCraetedTime";
        Object values[] = {userId};
        return this.getHibernateTemplate().find(hql,values);
    }

    @Override
    public List statisByMemo(int userId) {
        System.out.println("---------------------根据用途进行账单统计--------------------------");
        String hql="select new com.pf.model.vo.BillMemoStatis(b.billMemo,count (b.billMemo)) from TBill b where b.TUser.userId=? group by b.billMemo";
        Object values[] = {userId};
        return this.getHibernateTemplate().find(hql,values);
    }
}
