package com.codemonkeys.getSomeRest.DTO;

import java.util.List;

public class UserListWithLessInfo {


    private String code;
    private String info;
    private List<UserLessInfo> userList;

    public UserListWithLessInfo(String code, String info, List<UserLessInfo> userList) {
        this.code = code;
        this.info = info;
        this.userList = userList;
    }

    public UserListWithLessInfo(String code, String info) {
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

    public List<UserLessInfo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserLessInfo> userList) {
        this.userList = userList;
    }

}
