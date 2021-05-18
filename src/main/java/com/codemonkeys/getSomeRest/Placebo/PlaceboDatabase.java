package com.codemonkeys.getSomeRest.Placebo;

import com.codemonkeys.getSomeRest.Entities.ServiceCredentials;
import com.codemonkeys.getSomeRest.Entities.User;
import com.codemonkeys.getSomeRest.Enums.Roles;

import java.util.ArrayList;
import java.util.List;

// This class emulates an in-memory database. Sufficient for the scope of this hack box.
public class PlaceboDatabase {

    private static final PlaceboDatabase placeboDatabase = new PlaceboDatabase();
    private List<User> users;

    // Singletons have private constructor to prevent any other class from instantiating an object of it.
    private PlaceboDatabase() {

        // TODO: Redact the contents of this constructor before issuing this source code to the attacker/attackers.
        users = new ArrayList<>();
        List<Roles> rolesListGuest = new ArrayList<>();
        List<Roles> rolesListUser = new ArrayList<>();
        List<Roles> rolesListAdmin = new ArrayList<>();
        List<Roles> rolesListDeveloper = new ArrayList<>();
        rolesListGuest.add(Roles.GUEST);
        rolesListUser.add(Roles.USER);
        rolesListAdmin.add(Roles.ADMIN);
        rolesListDeveloper.add(Roles.DEVELOPER);
        users.add(new User("john.doe@gmail.com", "123456", true, rolesListGuest));
        users.add(new User("stephanie.rose@yahoo.com", "123456789", false, rolesListGuest));
        users.add(new User("bill.cliffy@outlook.com",
                "picture1",
                true,
                rolesListDeveloper,
                new ServiceCredentials("bill", "admin", "billssh", "!G0od@LuCk#^")));
        users.add(new User("peter.linen@outlook.com", "password", false, rolesListGuest));
        users.add(new User("jessie.briggs@gmail.com", "12345678", true, rolesListUser));
        users.add(new User("jacob.finley@yahoo.com", "111111", true, rolesListAdmin));
        users.add(new User("krista.lanteo@outlook.com", "123123", false, rolesListUser));
        users.add(new User("helen.carper@yahoo.com", "12345", true, rolesListGuest));
        users.add(new User("preacher.mellow@gmail.com", "1234567890", false, rolesListGuest));
        users.add(new User("rick.huston@gmail.com", "admin", false, rolesListAdmin));

    }

    public static PlaceboDatabase getInstance() {
        return placeboDatabase;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getActiveUsers() {
        List<User> activeUsers = new ArrayList<>();
        users.forEach( (user) -> {
            if (user.isEnabled()) {
                activeUsers.add(user);
            }
        });
        return activeUsers;
    }

    public List<User> getInactiveUsers() {
        List<User> inactiveUsers = new ArrayList<>();
        users.forEach( (user) -> {
            if (!user.isEnabled()) {
                inactiveUsers.add(user);
            }
        });
        return inactiveUsers;
    }

}
