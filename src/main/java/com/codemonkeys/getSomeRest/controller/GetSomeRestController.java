package com.codemonkeys.getSomeRest.controller;

import com.codemonkeys.getSomeRest.DTO.*;
import com.codemonkeys.getSomeRest.DTOMapper.DTOMapper;
import com.codemonkeys.getSomeRest.Entities.CommandList;
import com.codemonkeys.getSomeRest.Entities.Info;
import com.codemonkeys.getSomeRest.Entities.LoginResponse;
import com.codemonkeys.getSomeRest.Entities.User;
import com.codemonkeys.getSomeRest.Exceptions.CommandNotFoundException;
import com.codemonkeys.getSomeRest.Placebo.PlaceboDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetSomeRestController {

    private final PlaceboDatabase placeboDatabase = PlaceboDatabase.getInstance();
    private final Utilities utilities = new Utilities();
    private final AuthorizationChecker authChecker = new AuthorizationChecker();
    private final DTOMapper dtoMapper = new DTOMapper();

    @GetMapping("/error")
    public CommandNotFoundException returnError() {
        return new CommandNotFoundException("500", "Invalid command.");
    }

    // Guest and up command.
    @GetMapping("/rest/api/commandList")
    public CommandList getAllCommands() {
        return new CommandList();
    }

    // Guest and up command.
    @GetMapping("/rest/api/info")
    public Info getInfo() {
        return new Info();
    }

    // Debug developer only command.
    @GetMapping("/rest/api/getAllUsersDebug/sessionToken({sessionToken})")
    public UserListWithInfo getAllUsersDebug(@PathVariable String sessionToken) {

        // Check if this token exists and which user is tied to it.
        User userWithToken = utilities.findUserWithSessionToken(sessionToken);
        if (userWithToken != null) {

            // Has valid session token.
            // Check if is permitted to do so with roles.
            if (authChecker.isPermittedToActDeveloper(userWithToken)) {

                // All good. Return results.
                return new UserListWithInfo("700", "Request successful!", placeboDatabase.getUsers());

            } else {

                // Doesn't have the required role.
                return new UserListWithInfo("702", "You do not have permission to do this.");

            }

        } else {

            // No token stored like that, not logged in.
            return new UserListWithInfo("701", "There is no active token like that! Are you logged in?");

        }

    }

    // Admin and Developer developer only command.
    @GetMapping("/rest/api/getAllUsersInfo/sessionToken({sessionToken})")
    public UserListWithLessInfo getAllUsersInfo(@PathVariable String sessionToken) {

        // Check if this token exists and which user is tied to it.
        User userWithToken = utilities.findUserWithSessionToken(sessionToken);
        if (userWithToken != null) {

            // Has valid session token.
            // Check if is permitted to do so with roles.
            if (authChecker.isPermittedToActAdmin(userWithToken) || authChecker.isPermittedToActDeveloper(userWithToken)) {

                // All good. Return results.
                List<User> userList = placeboDatabase.getUsers();
                List<UserLessInfo> userLessInfoList = new ArrayList<>();
                userList.forEach( (user) -> {
                    userLessInfoList.add(dtoMapper.mapUserToUserLessInfo(user));
                });
                return new UserListWithLessInfo("700", "Request successful!", userLessInfoList);

            } else {

                // Doesn't have the required role.
                return new UserListWithLessInfo("702", "You do not have permission to do this.");

            }

        } else {

            // No token stored like that, not logged in.
            return new UserListWithLessInfo("701", "There is no active token like that! Are you logged in?");

        }

    }

    // Any role command.
    @GetMapping("/rest/api/getAllUsers")
    public UserListWithLeastInfo getAllUsers() {

        // No authorization or permission checks needed. Publicly available command.
        List<User> userList = placeboDatabase.getUsers();
        List<UserLeastInfo> userLessInfoList = new ArrayList<>();
        userList.forEach( (user) -> {
            userLessInfoList.add(dtoMapper.mapUserToUserLeastInfo(user));
        });
        return new UserListWithLeastInfo("700", "Request successful!", userLessInfoList);

    }

    @PostMapping("/rest/api/logout/user({inputUser})")
    public LoginResponse logoutUser(@PathVariable String inputUser) {

        // Get a list of all active users.
        List<User> allUsers = placeboDatabase.getUsers();

        // Prepare empty user to store potentially valid one.
        User validUser = null;

        // Check if received user credentials match those in placebo database.
        int index = 0;
        boolean userFound = false;
        // Stop iterating when user found or when whole list has been searched.
        while (!userFound && index < allUsers.size()) {

            if (allUsers.get(index).getUsername().equals(inputUser)) {
                validUser = allUsers.get(index);
                userFound = true;
            }
            index++;
        }

        if (userFound) {

            if (validUser.getSessionToken() != null) {

                // Set session token to null and log the user out.
                validUser.setSessionToken(null);
                return new LoginResponse("000", "Successfully logged out!");

            } else {

                // Do nothing and return response that user is not logged in.
                return new LoginResponse("001", "Error! User not logged in!");

            }

        }

        // Nothing was found in active users.
        return new LoginResponse("801", "This user doesn't exist.");

    }

    @PostMapping("/rest/api/login/user({inputUsername})pass({inputPassword})")
    public LoginResponse loginUser(@PathVariable String inputUsername, @PathVariable String inputPassword) {

        try {

            // Get a list of all active users.
            List<User> allUsers = placeboDatabase.getUsers();

            // Prepare empty user to store potentially valid one.
            User validUser = null;

            // Check if received user credentials match those in placebo database.
            int index = 0;
            boolean userFound = false;
            // Stop iterating when user found or when whole list has been searched.
            while (!userFound && index < allUsers.size()) {

                if (allUsers.get(index).getUsername().equals(inputUsername)) {
                    validUser = allUsers.get(index);
                    userFound = true;
                }
                index++;
            }

            // Check if valid user was found.
            if (validUser != null) {

                // User exists, check if it is enabled.
                if (validUser.isEnabled()) {

                    // Prepare hashes for comparison.
                    String hashedUserPasswordInDB = validUser.getPassword();
                    String hashedIncomingPassword = inputPassword;

                    // Check password.
                    if (hashedUserPasswordInDB.equals(hashedIncomingPassword)) {

                        // Generate a session token for the user.
                        validUser.setSessionToken(utilities.generateSessionToken());
                        return new LoginResponse("800", "Login successful!", validUser.getSessionToken());

                    } else {

                        // Hash doesn't match, therefore bad password.
                        // It is by design that it doesn't show an ambiguous message like password OR username is incorrect.
                        // More information to the attacker.
                        return new LoginResponse("803", "Incorrect password!");

                    }

                // User is disabled.
                } else {

                    return new LoginResponse("802", "This user is disabled.");

                }

            // No such username in active users.
            } else {

                // Nothing was found in active users.
                return new LoginResponse("801", "This user doesn't exist.");

            }

        // Some heavy brute-forcing or buffer overflow attacks might crash this method, so I'm wrapping it in try-catch.
        } catch (Exception e) {

            return new LoginResponse("804", "An exception occurred, you are brute-forcing too hard.");

        }
    }
}
