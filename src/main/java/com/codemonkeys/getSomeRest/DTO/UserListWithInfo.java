package com.codemonkeys.getSomeRest.DTO;

import com.codemonkeys.getSomeRest.Entities.User;

import java.util.List;

public class UserListWithInfo {

    private String code;
    private String info;
    private List<User> userList;

    public UserListWithInfo(String code, String info, List<User> userList) {
        this.code = code;
        this.info = info;
        this.userList = userList;
    }

    public UserListWithInfo(String code, String info) {
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
