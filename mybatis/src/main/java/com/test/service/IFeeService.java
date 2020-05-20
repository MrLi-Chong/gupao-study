package com.test.service;

import com.test.entity.Fee;

import java.util.Date;
import java.util.List;

public interface IFeeService {
    void insertFee(Fee fee, Date feeDate);

    List<Fee> queryFee(Fee fee);
}
