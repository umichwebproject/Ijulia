package com.umich.ijulia.service;

import com.umich.ijulia.dataobject.LoginTicket;

public interface LoginTicketService {
    //增加ticket
    String addTicket(int userId);
    //更改ticket状态
    void updatestatus(String ticket);
}
