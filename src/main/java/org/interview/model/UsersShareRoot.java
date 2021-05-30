package org.interview.model;

import java.util.HashMap;
import java.util.Map;

public class UsersShareRoot {

    private double rootUserBalance;

    private Map<String ,UsersShareNode> linkedUsers;

    public UsersShareRoot() {
        this.linkedUsers = new HashMap<>();
    }

    public void updateUserShare(String userId, double usersShare){
        if(!linkedUsers.containsKey(userId))
            linkedUsers.put(userId, new UsersShareNode(userId));

        UsersShareNode shareNode = linkedUsers.get(userId);
        shareNode.updateUsersBalance(usersShare);
        System.out.println("user with "+userId+" share updated");
        rootUserBalance = rootUserBalance - usersShare;
    }

    public Map<String, UsersShareNode> getLinkedUsers() {
        return linkedUsers;
    }
}
