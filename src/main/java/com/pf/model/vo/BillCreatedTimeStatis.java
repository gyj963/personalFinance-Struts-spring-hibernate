package com.pf.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 13-12-28.
 */
public class BillCreatedTimeStatis {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date billCreatedTime;
    private BigDecimal billMoney;

    public BillCreatedTimeStatis() {
    }

    public BillCreatedTimeStatis(Date billCreatedTime, BigDecimal billMoney) {
        this.billCreatedTime=billCreatedTime;
        this.billMoney = billMoney;
    }

    @Override
    public String toString() {
        return "BillCreatedTimeStatis{" +
                "billCreatedTime=" + billCreatedTime +
                ", billMoney=" + billMoney +
                '}';
    }

    public Date getBillCreatedTime() {
        return billCreatedTime;
    }

    public void setBillCreatedTime(Date billCreatedTime) {
        this.billCreatedTime = billCreatedTime;
    }

    public BigDecimal getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(BigDecimal billMoney) {
        this.billMoney = billMoney;
    }
}
