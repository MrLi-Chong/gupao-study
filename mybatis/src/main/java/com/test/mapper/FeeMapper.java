package com.test.mapper;

import com.test.entity.Fee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface FeeMapper {
    void insertFee(@Param("fee") Fee fee, @Param("feeDate") Date feeDate);

    List<Fee> queryFee(Fee fee);
}
