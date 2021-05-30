package org.interview.service;

import org.interview.model.Expense;
import org.interview.model.Group;
import org.interview.model.User;
import org.interview.model.UsersShareOutput;

import java.util.List;
import java.util.Set;

public interface GroupService {

    public String addGroup(String groupName, String createdBy);
    public Group getGroupById(String groupId) throws Exception;
    public void addUserToGroup(String groupId, String userId) throws Exception;
    public void addExpenseAndCalculateUserShare(Expense groupExpense) throws Exception;
    public Set<UsersShareOutput> getGroupBalancesForUsers(String groupId) throws Exception;
}
