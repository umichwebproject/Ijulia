package com.umich.ijulia.enums;

import lombok.Getter;

@Getter
public enum UserStatusEnum {
    USER_NORMAL(0,"用户状态正常"),
    USER_BAN(1,"用户被封禁"),
    USER_DELETED(2,"用户已经注销"),
    ;

    private Integer code;
    private String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
