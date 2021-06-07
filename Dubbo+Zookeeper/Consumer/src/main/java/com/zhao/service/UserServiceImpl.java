package com.zhao.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Reference
    TicketService ticketService;

    @Override
    public void getTicket() {
        String ticket = ticketService.ticket();
        System.out.println("get " + ticket);
    }
}
