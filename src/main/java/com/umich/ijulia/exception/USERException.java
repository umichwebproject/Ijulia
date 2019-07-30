package com.umich.ijulia.exception;

import com.umich.ijulia.enums.UserResultEnum;

public class USERException extends RuntimeException{
    private Integer code;

    public USERException(UserResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public USERException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code =code;
    }
}
