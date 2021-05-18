package com.codemonkeys.getSomeRest.Exceptions;

public class CommandNotAuthorizedException {

    private String code;
    private String info;

    public CommandNotAuthorizedException() {
    }

    public CommandNotAuthorizedException(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
