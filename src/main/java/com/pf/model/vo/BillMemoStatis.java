package com.pf.model.vo;

/**
 * Created by Administrator on 13-12-28.
 */
public class BillMemoStatis {
    private String billMemo;
    private Long  cnt;

    public BillMemoStatis() {
    }

    public BillMemoStatis(String billMemo, Long cnt) {
        this.billMemo=billMemo;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "BillMemoStatis{" +
                "billMemo=" + billMemo +
                ", cnt=" + cnt +
                '}';
    }

    public String getBillMemo() {
        return billMemo;
    }

    public void setBillMemo(String billMemo) {
        this.billMemo = billMemo;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }
}
