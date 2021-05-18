package com.codemonkeys.getSomeRest.controller;

import com.codemonkeys.getSomeRest.Entities.HashResult;
import com.codemonkeys.getSomeRest.Entities.User;
import com.codemonkeys.getSomeRest.Placebo.PlaceboDatabase;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

public class Utilities {

    PlaceboDatabase placeboDatabase = PlaceboDatabase.getInstance();

    public HashResult getMD5Hash(String inputString) {

        // Init MessageDigest with MD5 algorithm.
        String hashingAlgorithm = "MD5";
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(hashingAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Define password, salt and the combine them together for the final to-be-hashed String.
        String password = inputString;
        long salt = System.currentTimeMillis();
        String passwordToBeHashed = password + salt;

        // Get byte array from String and then hash that byte array.
        byte[] passwordBytes = passwordToBeHashed.getBytes(StandardCharsets.UTF_8);
        assert messageDigest != null;
        byte[] hashedPasswordBytes = messageDigest.digest(passwordBytes);

        // Prepare a StringBuilder and write all the hashed bytes to it in hexadecimal as a String.
        StringBuilder hashedPasswordAsHex = new StringBuilder();
        for (byte currentByte : hashedPasswordBytes) {
            hashedPasswordAsHex.append(String.format("%02x", currentByte));
        }

        // Return HashResult object.
        return new HashResult(salt, hashingAlgorithm, hashedPasswordAsHex.toString());

    }

    public HashResult getMD5HashWithCustomSalt(String inputString, String salt) {

        // Init MessageDigest with MD5 algorithm.
        String hashingAlgorithm = "MD5";
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(hashingAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Define password, salt and the combine them together for the final to-be-hashed String.
        String password = inputString;
        String passwordToBeHashed = password + salt;

        // Get byte array from String and then hash that byte array.
        byte[] passwordBytes = passwordToBeHashed.getBytes(StandardCharsets.UTF_8);
        assert messageDigest != null;
        byte[] hashedPasswordBytes = messageDigest.digest(passwordBytes);

        // Prepare a StringBuilder and write all the hashed bytes to it in hexadecimal as a String.
        StringBuilder hashedPasswordAsHex = new StringBuilder();
        for (byte currentByte : hashedPasswordBytes) {
            hashedPasswordAsHex.append(String.format("%02x", currentByte));
        }

        // Return HashResult object.
        return new HashResult(Long.parseLong(salt), hashingAlgorithm, hashedPasswordAsHex.toString());

    }

    public String generateSessionToken() {

        int targetStringLength = 512;
        StringBuilder outputToken = new StringBuilder();
        Random random = new Random();
        int max = 90;
        int min = 48;

        // Generate a 512 alphanumeric String to be used as a session token.
        while (outputToken.length() < targetStringLength) {
            int generatedInt = random.nextInt(max - min) + min;
            if ( (generatedInt >= 65 && generatedInt <= 90) || (generatedInt >= 48 && generatedInt <= 57) ) {
                outputToken.append( (char) generatedInt);
            }
        }
        return outputToken.toString();
    }

    // Returns active user with that sessionToken if it exists otherwise returns null.
    public User findUserWithSessionToken(String sessionToken) {
        List<User> activeUsers = placeboDatabase.getActiveUsers();
        for (User activeUser : activeUsers) {
            if (activeUser.getSessionToken() != null) {
                if (activeUser.getSessionToken().equals(sessionToken)) {
                    return activeUser;
                }
            }
        }
        return null;
    }

}
