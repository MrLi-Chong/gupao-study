package com.test.entity;


import java.util.Date;

/**
 * @Author Administrator
 * @Date 2020/5/20 20:42
 */
public class Fee {
    private Integer id;
    private Double feeAmt;
    private Date feeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFeeAmt(Double feeAmt) {
        this.feeAmt = feeAmt;
    }

    public Date getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
    }
}
