package com.umich.ijulia.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
public class LoginTicket {
    @Id
    private int id;
    private int userId;
    private Date expired;
    private int status;
    private String ticket;
}
