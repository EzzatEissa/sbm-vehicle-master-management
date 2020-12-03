package com.sbm.vehicle.common.exception;

import lombok.Data;

@Data
public class ErrorResponse {

    String msg;
    Integer code;
    String type;

    public ErrorResponse(String errorMessage, Integer errorCode) {
        super();
        this.msg = errorMessage;
        this.code = errorCode;
        this.type = "error";
    }

    public ErrorResponse() { }
}
