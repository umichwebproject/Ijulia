package com.umich.ijulia.repository;

import com.umich.ijulia.dataobject.LoginTicket;
import com.umich.ijulia.dataobject.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginTicketRepository extends JpaRepository<LoginTicket,String>  {
    //查找ticket
    LoginTicket findByTicket(String ticket);
}
