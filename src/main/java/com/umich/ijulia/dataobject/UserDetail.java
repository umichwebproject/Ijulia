package com.umich.ijulia.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.umich.ijulia.utils.serialize.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class UserDetail {
    /**用户的id */
    @Id
    private int userId;
    /*email:用户邮箱，因此我们使用id或者邮箱作为登陆验证的方式，
    **ps：我认为大部分人对数字的记忆是不是很敏感的，因此用id其实不是一个很好的用户留存手段，邮箱的话又很繁琐
    *  TODO:加上改用手机验证码的方式登陆
    *  TODO：考虑对海外手机等验证的问题
    *  TODO：邮箱确认问题
    *  TODO：邮箱修改密码验证
    */
    private String email;
    /*用户名，可以重复
    * 我认为用户名可以重复可以增加用户的自由度，因为先后顺序而剥夺自由度是一个很错误的决定。
    * */
    private String username;
    /*密码，请注意，密码应该加盐后保存md5值*/
    private String password;
    /*盐*/
    private String salt;
    /*头像链接
    * TODO:要先默认创建一个，不如加载到static静态资源里，找100个不同的。
    * TODO：哦可以找通子哥或者谁或者自己搞GAN的生成一堆头像，奥里给
    * */
    private String headUrl;
    /** 创建时间. */
    private Date createTime;
    /**用户状态，定义0为正常，1为被封禁，2为被注销*/
    private int userStatus;
}
