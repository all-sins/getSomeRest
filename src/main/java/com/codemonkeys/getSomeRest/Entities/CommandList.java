package com.codemonkeys.getSomeRest.Entities;

import java.util.ArrayList;
import java.util.List;

public class CommandList {

    private List<String> commandList = new ArrayList<>();

    public CommandList() {
        commandList.add("/rest/api/info");
        commandList.add("/rest/api/commandList");
        commandList.add("/rest/api/login/user({inputUsername})pass({inputPassword})");
        commandList.add("/rest/api/logout/user({inputUsername})");
        commandList.add("/rest/api/getAllUsers");
        commandList.add("/rest/api/getAllUsersInfo/sessionToken({sessionToken})");
        commandList.add("/rest/api/getAllUsersDebug/sessionToken({sessionToken})");
    }

    public List<String> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<String> commandList) {
        this.commandList = commandList;
    }
}
