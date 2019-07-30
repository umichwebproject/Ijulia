package com.umich.ijulia.service.impl;

import com.umich.ijulia.dataobject.LoginTicket;
import com.umich.ijulia.repository.LoginTicketRepository;
import com.umich.ijulia.service.LoginTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class LoginTicketServiceImpl implements LoginTicketService {
    @Autowired
    private LoginTicketRepository loginTicketRepository;
    @Override
    public String addTicket(int userId) {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date now = new Date();
        now.setTime(3600*24*7*1000+now.getTime());
        loginTicket.setExpired(now);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        loginTicketRepository.save(loginTicket);
        return loginTicket.getTicket();
    }

    @Override
    public void updatestatus(String ticket) {
        LoginTicket loginTicket = loginTicketRepository.findByTicket(ticket);
        loginTicket.setStatus(1);
        loginTicketRepository.save(loginTicket);
    }
}
