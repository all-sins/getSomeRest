package com.codemonkeys.getSomeRest.Entities;

public class LoginResponse {

    private String code;
    private String info;
    private String sessionToken;

    public LoginResponse(String code, String info, String sessionToken) {
        this.code = code;
        this.info = info;
        this.sessionToken = sessionToken;
    }

    public LoginResponse(String code, String info) {
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

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
