package com.iroving.springcloud.service.impl;

import com.iroving.springcloud.service.IPaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentHystrixServiceImpl implements IPaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id){
        log.info("consumer兜底");
        return "线程池consumer："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }

    //失败
    @Override
    public String paymentInfo_TimeOut(Integer id){
        log.info("consumer兜底");
        return "线程池consumer："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)";
    }
}
