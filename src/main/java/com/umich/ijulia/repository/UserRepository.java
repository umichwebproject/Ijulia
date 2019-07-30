package com.umich.ijulia.repository;

import com.umich.ijulia.dataobject.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetail,String> {
    //查找用户
    UserDetail findByUserId(int userId);
    UserDetail findByEmail(String email);
}
