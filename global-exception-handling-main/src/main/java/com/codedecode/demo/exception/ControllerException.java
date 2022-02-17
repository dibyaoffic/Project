package com.codedecode.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{
    private String errCode;
    private String errMessage;
   
    public ControllerException() {
    }
    public  ControllerException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }
    public String getErrCode() {
        return errCode;
    }
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    public String getErrMessage() {
        return errMessage;
    }
    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
