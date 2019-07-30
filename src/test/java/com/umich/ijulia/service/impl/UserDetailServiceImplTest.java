package com.umich.ijulia.service.impl;

import com.umich.ijulia.dataobject.UserDetail;
import com.umich.ijulia.dto.UserDetailDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailServiceImplTest {

    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Test
    public void addUser() {
        UserDetail result = userDetailService.addUser("baoyuan1@umich.edu","lby1","123456");
        Assert.assertNotNull(result);

    }

    @Test
    public void changePassword() {
        UserDetail userDetail = userDetailService.changePassword(3,"131");
        Assert.assertNotNull(userDetail.getPassword());
    }

    @Test
    public void deleteUser() {
    }
}