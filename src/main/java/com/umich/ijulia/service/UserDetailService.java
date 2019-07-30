package com.umich.ijulia.service;

import com.umich.ijulia.dataobject.UserDetail;
import com.umich.ijulia.dto.UserDetailDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface UserDetailService{
    //新增用户
    UserDetail addUser(String email,String userName,String password);
    //更改密码
    UserDetail changePassword(int userId,String password);
    //注销用户
    UserDetailDTO deleteUser(int userId, String password);
    //TODO 更改用户名
    //登陆
    String login(String email,String password);
}
