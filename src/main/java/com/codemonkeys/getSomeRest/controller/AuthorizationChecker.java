package com.codemonkeys.getSomeRest.controller;

import com.codemonkeys.getSomeRest.Entities.User;
import com.codemonkeys.getSomeRest.Enums.Roles;

public class AuthorizationChecker {

    public boolean userIsAuthenticated(User user, String sessionToken) {
        return user.getSessionToken().equals(sessionToken);
    }

    public boolean isPermittedToActGuest(User user) {
        return user.getRoles().contains(Roles.GUEST);
    }

    public boolean isPermittedToActUser(User user) {
        return user.getRoles().contains(Roles.USER);
    }

    public boolean isPermittedToActAdmin(User user) {
        return user.getRoles().contains(Roles.ADMIN);
    }

    public boolean isPermittedToActDeveloper(User user) {
        return user.getRoles().contains(Roles.DEVELOPER);
    }

}
