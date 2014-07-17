package com.pf.service;

import com.pf.model.entity.TBill;
import com.pf.model.entity.TUser;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
public interface BillManager {
    public void insertBill(TBill tbill);

    public void updateBill(TBill tbill);

    List<TBill> listBill(int userId);

    TUser getUserById(int id);

    TBill getBillById(int id);

    public void deleteBillById(int id);

    public List<TBill> filterByDate(Date minDate, Date maxDate, int userId);

    List statisByStyle(int userId);

    List statisByCreatedTimeAndStyleIsPay(int userId);

    List statisByCreatedTimeAndStyleIsIncome(int userId);

    List statisByMemo(int userId);
}
