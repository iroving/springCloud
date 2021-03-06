package com.iroving.springcloud.dao;

import com.iroving.springcloud.entity.Payment;
import feign.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentDao {
    @Insert({"insert into payment(id,serial) values(#{id},#{serial})"})
    int create(Payment payment);

    @Select("select * from payment where id=#{id}")
    Payment getPaymentById(@Param("id") Long id);
}