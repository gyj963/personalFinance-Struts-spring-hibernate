package com.pf.service.impl;

import com.pf.dao.BaseDAO;
import com.pf.dao.BillDAO;
import com.pf.dao.UserDAO;
import com.pf.model.entity.TBill;
import com.pf.model.entity.TUser;
import com.pf.service.BillManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 13-12-26.
 */
@Service
public class BillManagerImpl implements BillManager{
    @Autowired
    private BillDAO billdao;
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void insertBill(TBill tbill){
        billdao.save(tbill);
    }

    @Override
    @Transactional
    public void updateBill(TBill tbill) {
        billdao.update(tbill);
    }

    @Override
    public List<TBill> listBill(int userId) {
        List<TBill> billList=billdao.listBill(userId);
        return billList;
    }

    @Override
    public TUser getUserById(int id) {
        return userDAO.get(id);
    }

    @Override
    public TBill getBillById(int id) {
        return billdao.get(id);
    }

    @Override
    @Transactional
    public void deleteBillById(int id){
        billdao.deleteById(TBill.class,id);
    }

    @Override
    public List<TBill> filterByDate(Date minDate, Date maxDate, int userId) {
        return billdao.filterByDate(minDate,maxDate,userId);
    }
    @Override
    public List statisByStyle(int userId) {
        return billdao.statisByStyle(userId);
    }

    @Override
    public List statisByCreatedTimeAndStyleIsPay(int userId) {
        return billdao.statisByCreatedTimeAndStyleIsPay(userId);
    }
    @Override
    public List statisByCreatedTimeAndStyleIsIncome(int userId) {
        return billdao.statisByCreatedTimeAndStyleIsIncome(userId);
    }

    @Override
    public List statisByMemo(int userId) {
        return billdao.statisByMemo(userId);
    }
}
