package com.iroving.springcloud.service;

import com.iroving.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IPaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
