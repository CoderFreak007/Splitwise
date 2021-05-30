package org.interview.model;

public class UsersShareNode {

   private String userId;

   private double usersBalance;

    public UsersShareNode(String userId) {
        this.userId = userId;
    }


    public Double getUsersBalance() {
        return usersBalance;
    }

    public void updateUsersBalance(double usersShare){
        usersBalance = usersBalance + usersShare;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "UsersShareNode{" +
                "userId='" + userId + '\'' +
                ", usersBalance=" + usersBalance +
                '}';
    }
}
