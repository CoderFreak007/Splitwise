package org.interview.model;

import org.interview.service.UserService;
import org.interview.serviceImpl.UserServiceImpl;

import java.util.*;

public class Group {

    private String id;

    private String name;

    private String createdBy;

    private List<User> users;

    private List<Expense> expenseHistory;

    private Map<String, UsersShareRoot> usersShareRootMap;

    public Group(String name, String createdBy) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.createdBy = createdBy;
        this.users = new ArrayList<>();
        this.expenseHistory = new ArrayList<>();
        this.usersShareRootMap = new HashMap<>();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Expense> getExpenseHistory() {
        return expenseHistory;
    }

    public void addUser(User user){
        users.add(user);
        usersShareRootMap.put(user.getId(), new UsersShareRoot());
    }

    public void addExpense(Expense expense){
        expenseHistory.add(expense);
    }

    public Map<String, UsersShareRoot> getUsersShareRootMap() {
        return usersShareRootMap;
    }

    public void validateUserInGroup(String userId) throws Exception{
        UserService userService = UserServiceImpl.getInstance();
        User user = userService.getUserByUserId(userId);
        for(User groupUser : users){
            if(groupUser.getId().equals(userId))
                return;
        }
        throw new Exception("user "+ user.getName()+"does not exist on group");
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
