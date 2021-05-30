package org.interview.serviceImpl;

import org.interview.model.Expense;
import org.interview.model.Group;
import org.interview.model.User;
import org.interview.model.UsersShareRoot;
import org.interview.service.ShareCalculationService;

import java.util.List;
import java.util.Map;

public class EqualShareCalculaionService implements ShareCalculationService {

    @Override
    public void calculateUsersShareAndUpdateGroupBalance(Group group, Expense expense){

        List<User> groupUsers = group.getUsers();
        int noOfUsersInGroup = groupUsers.size();
        Map<String, UsersShareRoot> usersShareRootMap = group.getUsersShareRootMap();
        UsersShareRoot usersShareRoot = usersShareRootMap.get(expense.getUserId());

        for(User user : groupUsers){
            String userId = user.getId();
            if(!userId.equals(expense.getUserId())){
                double userShare = expense.getUserExpense()/noOfUsersInGroup;
                usersShareRoot.updateUserShare(userId, -userShare);
                UsersShareRoot linkedusersShareRoot = usersShareRootMap.get(userId);
                linkedusersShareRoot.updateUserShare(expense.getUserId(), userShare);
            }
        }


    }



}
