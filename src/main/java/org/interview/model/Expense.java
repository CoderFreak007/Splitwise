package org.interview.model;

public class Expense {

   private String userId;

   private String groupId;

    private Double userExpense;

    public Expense(String userId, String groupId, Double userExpense) {
        this.userId = userId;
        this.groupId = groupId;
        this.userExpense = userExpense;
    }

    public String getUserId() {
        return userId;
    }

    public Double getUserExpense() {
        return userExpense;
    }


    public String getGroupId() {
        return groupId;
    }
}
