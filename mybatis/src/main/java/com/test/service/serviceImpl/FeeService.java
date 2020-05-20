package com.test.service.serviceImpl;

import com.test.entity.Fee;
import com.test.mapper.FeeMapper;
import com.test.service.IFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/5/20 20:50
 */
@Service
public class FeeService implements IFeeService {
    @Autowired
    private FeeMapper mapper;

    @Override
    public void insertFee(Fee fee, Date feeDate) {
        mapper.insertFee(fee,feeDate);
    }

    @Override
    public List<Fee> queryFee(Fee fee) {
        return mapper.queryFee(fee);
    }
}
