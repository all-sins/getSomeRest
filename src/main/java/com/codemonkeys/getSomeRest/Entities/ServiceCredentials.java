package com.codemonkeys.getSomeRest.Entities;

public class ServiceCredentials {

    private String FTP_User;
    private String FTP_Password;

    private String SSH_User;
    private String SSH_Password;

    public ServiceCredentials(String FTP_User, String FTP_Password, String SSH_User, String SSH_Password) {
        this.FTP_User = FTP_User;
        this.FTP_Password = FTP_Password;
        this.SSH_User = SSH_User;
        this.SSH_Password = SSH_Password;
    }

    public String getFTP_User() {
        return FTP_User;
    }

    public void setFTP_User(String FTP_User) {
        this.FTP_User = FTP_User;
    }

    public String getFTP_Password() {
        return FTP_Password;
    }

    public void setFTP_Password(String FTP_Password) {
        this.FTP_Password = FTP_Password;
    }

    public String getSSH_User() {
        return SSH_User;
    }

    public void setSSH_User(String SSH_User) {
        this.SSH_User = SSH_User;
    }

    public String getSSH_Password() {
        return SSH_Password;
    }

    public void setSSH_Password(String SSH_Password) {
        this.SSH_Password = SSH_Password;
    }
}
