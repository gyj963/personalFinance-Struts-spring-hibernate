package com.pf.dao;

import com.pf.model.entity.TBill;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
public interface BillDAO extends BaseDAO<TBill> {
    public List<TBill> listBill(int userId);

    List<TBill> filterByDate(Date minDate, Date maxDate, int userId);

    List statisByStyle(int userId);

    List statisByCreatedTimeAndStyleIsPay(int userId);

    List statisByCreatedTimeAndStyleIsIncome(int userId);

    List statisByMemo(int userId);
}
