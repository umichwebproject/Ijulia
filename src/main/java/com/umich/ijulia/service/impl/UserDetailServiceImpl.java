package com.umich.ijulia.service.impl;

import com.umich.ijulia.dataobject.UserDetail;
import com.umich.ijulia.dto.UserDetailDTO;
import com.umich.ijulia.enums.UserResultEnum;
import com.umich.ijulia.enums.UserStatusEnum;
import com.umich.ijulia.exception.USERException;
import com.umich.ijulia.repository.UserRepository;
import com.umich.ijulia.service.LoginTicketService;
import com.umich.ijulia.service.UserDetailService;
import com.umich.ijulia.utils.CookieUtil;
import com.umich.ijulia.utils.Password2MD5;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginTicketService loginTicketService;

    @Override
    @Transactional
    public UserDetail addUser(String email,String userName,String password) {
        /*不做用户名是否存在的检查
         *从UserdetailDTO那里传回来id、用户名、password、salt
         * 所以说盐要controller生成吗？
         */
        //TODO 用户名合法性检查？前端？后端？
        //检查用户名是否为空（前端也要检查）
        //TODO 注册时间限制（防止有人大量post来注册），可以通过短信验证码验证

        if(StringUtils.isEmpty(userName)){
            throw new USERException(UserResultEnum.USER_EMPTY_NAME);
        }
        //检查密码是否为空
        if(StringUtils.isEmpty(password)){
            throw new USERException(UserResultEnum.USER_EMPTY_NAME);
        }
        //创建一个新的用户
        UserDetail userDetail = new UserDetail();
        //设置邮箱
        userDetail.setEmail(email);
        //设置用户名
        userDetail.setUsername(userName);
        //生成盐
        userDetail.setSalt(UUID.randomUUID().toString().substring(0,4));
        //加密后生成密码
        userDetail.setPassword(Password2MD5.md5(password+userDetail.getSalt()));
        //状态为正常
        userDetail.setUserStatus(UserStatusEnum.USER_NORMAL.getCode());
        userRepository.save(userDetail);
        return userDetail;
    }

    @Override
    @Transactional
    public UserDetail changePassword(int userId, String password) {
        UserDetail userDetail = userRepository.findByUserId(userId);
        if(userDetail==null){
            throw new USERException(UserResultEnum.USER_NOT_EXIST);
        }
        if(userDetail.getUserStatus()== UserStatusEnum.USER_DELETED.getCode()){
            throw new USERException(UserResultEnum.USER_NOT_EXIST);
        }
        userDetail.setPassword(Password2MD5.md5(password+userDetail.getSalt()));
        userRepository.save(userDetail);
        return userDetail;
    }

    @Override
    @Transactional
    public UserDetailDTO deleteUser(int userId, String password) {
        UserDetail userDetail = userRepository.findByUserId(userId);
        if(userDetail==null){
            throw new USERException(UserResultEnum.USER_NOT_EXIST);
        }
        if(userDetail.getUserStatus()== UserStatusEnum.USER_DELETED.getCode()){
            throw new USERException(UserResultEnum.USER_NOT_EXIST);
        }
        if(!userDetail.getPassword().equals(password)){
            throw new USERException(UserResultEnum.PASSWORD_ERROR);
        }
        userDetail.setUserStatus(UserStatusEnum.USER_DELETED.getCode());
        userRepository.save(userDetail);
        return null;
    }

    @Override
    public String login(String email, String password) {
        UserDetail userDetail = userRepository.findByEmail(email);
        if(StringUtils.isEmpty(email)){
            throw new USERException(UserResultEnum.USER_EMPTY_NAME);
        }
        if(StringUtils.isEmpty(password)){
            throw new USERException(UserResultEnum.USER_EMPTY_PASSWORD);
        }
        if(userDetail==null){
            throw new USERException(UserResultEnum.USER_NOT_EXIST);
        }
        if(!userDetail.getPassword().equals(Password2MD5.md5(password+userDetail.getSalt()))){
            throw new USERException(UserResultEnum.PASSWORD_ERROR);
        };
        String ticket = loginTicketService.addTicket(userDetail.getUserId());
        return ticket;
    }
}
