package com.umich.ijulia.service.impl;

import com.umich.ijulia.service.LoginTicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTicketServiceImplTest {

    @Autowired
    private LoginTicketService loginTicketService;
    @Test
    public void addTicket() {
        loginTicketService.addTicket(123);
    }

    @Test
    public void updatestatus() {
    }
}