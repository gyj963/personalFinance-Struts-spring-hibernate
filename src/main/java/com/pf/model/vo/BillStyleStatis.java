package com.pf.model.vo;

/**
 * Created by Administrator on 13-12-28.
 */
public class BillStyleStatis {
    private String billStyle;
    private Long  cnt;

    public BillStyleStatis() {
    }

    public BillStyleStatis(String billStyle, Long cnt) {
        this.billStyle=billStyle;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "BillStyleStatis{" +
                "billStyle=" + billStyle +
                ", cnt=" + cnt +
                '}';
    }

    public String getBillStyle() {
        return billStyle;
    }

    public void setBillStyle(String billStyle) {
        this.billStyle = billStyle;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }
}
