package com.umich.ijulia.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.umich.ijulia.utils.serialize.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@DynamicUpdate
public class UserDetailDTO {
    private int userId;
    private String username;
    private String salt;
    private String password;
    private String headUrl;
    /** 创建时间. */
}
