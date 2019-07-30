package com.umich.ijulia.enums;

import lombok.Getter;

@Getter
public enum UserResultEnum {
    USER_NOT_EXIST(1,"用户不存在"),
    PASSWORD_ERROR(2,"密码错误"),
    USER_EMPTY_NAME(3,"用户名为空"),
    USER_EMPTY_PASSWORD(4,"密码为空"),
    USER_NOT_LOGIN(5,"用户登陆状态错误"),
    ;

    private Integer code;
    private String message;

    UserResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
