package com.codemonkeys.getSomeRest.Entities;

import com.codemonkeys.getSomeRest.GetSomeRestApplication;
import com.codemonkeys.getSomeRest.Placebo.PlaceboDatabase;

public class Info {

    private long systemTime;
    private long totalUsers;
    private long activeUsers;
    private long inactiveUsers;
    private float systemUptimeInMinutes;

    public Info() {
        PlaceboDatabase placeboDatabase = PlaceboDatabase.getInstance();
        systemTime = System.currentTimeMillis();
        totalUsers = placeboDatabase.getUsers().size();
        activeUsers = placeboDatabase.getActiveUsers().size();
        inactiveUsers = placeboDatabase.getInactiveUsers().size();
        systemUptimeInMinutes = (float) (System.currentTimeMillis() - GetSomeRestApplication.getSystemInitTime()) / 1000 / 60;
    }

    public long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(long activeUsers) {
        this.activeUsers = activeUsers;
    }

    public long getInactiveUsers() {
        return inactiveUsers;
    }

    public void setInactiveUsers(long inactiveUsers) {
        this.inactiveUsers = inactiveUsers;
    }

    public float getsystemUptimeInMinutes() {
        return systemUptimeInMinutes;
    }

    public void setsystemUptimeInMinutes(float systemUptimeInMinutes) {
        this.systemUptimeInMinutes = systemUptimeInMinutes;
    }
}
