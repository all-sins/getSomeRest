package com.codemonkeys.getSomeRest.DTO;

import com.codemonkeys.getSomeRest.Enums.Roles;

import java.util.List;

public class UserLeastInfo {


    private String username;
    private long dateCreated;

    public UserLeastInfo() {
    }

    public UserLeastInfo(String username, long dateCreated, List<Roles> roles) {
        this.username = username;
        this.dateCreated = dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

}
