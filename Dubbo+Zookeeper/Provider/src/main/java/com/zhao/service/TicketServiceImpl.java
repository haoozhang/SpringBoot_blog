package com.zhao.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public String ticket() {
        return "lan ticket";
    }
}
