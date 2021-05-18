package com.codemonkeys.getSomeRest.Entities;

import com.codemonkeys.getSomeRest.Enums.Roles;
import com.codemonkeys.getSomeRest.controller.Utilities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class User {

    private final Utilities utilities = new Utilities();
    private String username;
    private String password;
    private long dateCreated;
    private String sessionToken = null;
    private Boolean enabled = false;
    private List<Roles> roles;
    private MessageDigest messageDigest = null;
    private ServiceCredentials serviceCredentials;

    {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public User(String username, String password) {

        // Set username.
        this.username = username;

        // Create hash for password and store it.
        // MD5(Password string + current date) -> stored password. ( See getMD5Hash(). )
        HashResult hashResult = utilities.getMD5Hash(password);
        this.password = hashResult.getHash();
        this.dateCreated = hashResult.getTimeOfHashing();

        // Enable account.
        this.enabled = false;

    }

    public User(String username, String password, List<Roles> roles) {

        // Set username.
        this.username = username;

        // Create hash for password and store it.
        // MD5(Password string + current date) -> stored password. ( See getMD5Hash(). )
        HashResult hashResult = utilities.getMD5Hash(password);
        this.password = hashResult.getHash();
        this.dateCreated = hashResult.getTimeOfHashing();

        // Set roles.
        this.roles = roles;

        // Enable account.
        this.enabled = true;

    }

    public User(String username, String password, Boolean enabled) {

        // Set username.
        this.username = username;

        // Create hash for password and store it.
        // MD5(Password string + current date) -> stored password. ( See getMD5Hash(). )
        HashResult hashResult = utilities.getMD5Hash(password);
        this.password = hashResult.getHash();
        this.dateCreated = hashResult.getTimeOfHashing();

        // Enable account.
        this.enabled = enabled;

    }

    public User(String username, String password, Boolean enabled, List<Roles> roles) {

        // Set username.
        this.username = username;

        // Create hash for password and store it.
        // MD5(Password string + current date) -> stored password. ( See getMD5Hash(). )
        HashResult hashResult = utilities.getMD5Hash(password);
        this.password = hashResult.getHash();
        this.dateCreated = hashResult.getTimeOfHashing();

        // Set enabled status.
        this.enabled = enabled;

        // Set roles.
        this.roles = roles;

    }

    public User(String username, String password, Boolean enabled, List<Roles> roles, ServiceCredentials serviceCredentials) {

        // Set username.
        this.username = username;

        // Create hash for password and store it.
        // MD5(Password string + current date) -> stored password. ( See getMD5Hash(). )
        HashResult hashResult = utilities.getMD5Hash(password);
        this.password = hashResult.getHash();
        this.dateCreated = hashResult.getTimeOfHashing();

        // Set service credentials.
        this.serviceCredentials = serviceCredentials;

        // Set enabled status.
        this.enabled = enabled;

        // Set roles.
        this.roles = roles;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // Current system time in milliseconds is used as a salt.
        // MD5(Password string + current date) -> stored password.
        password += System.currentTimeMillis();
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        this.password = Arrays.toString(messageDigest.digest(passwordBytes));
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public void removeRole(Roles role) {
        roles.forEach( (currentRole) -> {
            if (currentRole.equals(role)) {
                roles.remove(role);
            }
        });
    }

    public void addRole(Roles role) {
        roles.forEach( (currentRole) -> {
            if (!roles.contains(role)) {
                roles.add(role);
            }
        });
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated=" + dateCreated +
                ", sessionToken='" + sessionToken + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ServiceCredentials getServiceCredentials() {
        return serviceCredentials;
    }

    public void setServiceCredentials(ServiceCredentials serviceCredentials) {
        this.serviceCredentials = serviceCredentials;
    }
}
