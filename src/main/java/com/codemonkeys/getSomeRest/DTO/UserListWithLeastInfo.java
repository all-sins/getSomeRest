package com.codemonkeys.getSomeRest.DTO;

import java.util.List;

public class UserListWithLeastInfo {

    private String code;
    private String info;
    private List<UserLeastInfo> userList;

    public UserListWithLeastInfo(String code, String info, List<UserLeastInfo> userList) {
        this.code = code;
        this.info = info;
        this.userList = userList;
    }

    public UserListWithLeastInfo(String code, String info) {
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

    public List<UserLeastInfo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserLeastInfo> userList) {
        this.userList = userList;
    }


}
