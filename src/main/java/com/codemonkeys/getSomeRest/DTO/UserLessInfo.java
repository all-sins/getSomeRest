package com.codemonkeys.getSomeRest.DTO;

import com.codemonkeys.getSomeRest.Enums.Roles;

import java.util.List;

public class UserLessInfo {

    private String username;
    private long dateCreated;
    private List<Roles> roles;

    public UserLessInfo() {
    }

    public UserLessInfo(String username, long dateCreated, List<Roles> roles) {
        this.username = username;
        this.dateCreated = dateCreated;
        this.roles = roles;
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

}
