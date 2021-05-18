package com.codemonkeys.getSomeRest.DTO;

import com.codemonkeys.getSomeRest.Entities.User;
import com.codemonkeys.getSomeRest.Enums.Roles;

import java.util.List;

public class UserNoPass {

    private String username;
    private Boolean enabled;
    private List<Roles> roles;

    public UserNoPass() {
    }

    public UserNoPass(User user) {
        UserNoPass userNoPass = new UserNoPass();
        userNoPass.username = user.getUsername();
        userNoPass.enabled = user.isEnabled();
        userNoPass.roles = user.getRoles();
    }

}
