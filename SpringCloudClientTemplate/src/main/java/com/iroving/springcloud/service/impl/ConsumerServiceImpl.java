package com.iroving.springcloud.service.impl;

import com.iroving.springcloud.service.IConsumerService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerServiceImpl implements IConsumerService {
    @Override
    public String consumeMethod(Long id) {
        return "这边报错啦，id为：" + id;
    }
}
