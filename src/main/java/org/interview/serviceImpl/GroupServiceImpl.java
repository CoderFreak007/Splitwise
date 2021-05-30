package org.interview.serviceImpl;

import org.interview.model.*;
import org.interview.service.GroupService;
import org.interview.service.ShareCalculationService;
import org.interview.service.UserService;

import java.util.*;

public class GroupServiceImpl implements GroupService {

    private List<Group> groups;

    public GroupServiceImpl() {
        this.groups = new ArrayList<>();
    }

    @Override
    public String addGroup(String groupName, String createdBy){
        Group group = new Group(groupName, createdBy);
        groups.add(group);
        System.out.println("group Added"+group);
        return group.getId();
    }

    @Override
    public Group getGroupById(String groupId) throws Exception{
        for(Group group : groups){
            if(groupId.equals(groupId)) {
                return  group;
            }
        }
        throw new Exception("Group does not exist for id"+groupId);
    }

    @Override
    public void addUserToGroup(String groupId, String userId) throws Exception {

        User user = UserServiceImpl.getInstance().getUserByUserId(userId);
        for(Group group : groups){
            if(groupId.equals(groupId)) {
                System.out.println(user.getName()+" added to group "+group.getName());
                group.addUser(user); break;
            }
        }
    }

    @Override
    public void addExpenseAndCalculateUserShare(Expense groupExpense) throws Exception{
        Group group = getGroupById(groupExpense.getGroupId());
        group.validateUserInGroup(groupExpense.getUserId());
        ShareCalculationService shareCalculationService = new EqualShareCalculaionService();
        shareCalculationService.calculateUsersShareAndUpdateGroupBalance(group, groupExpense);

    }

    @Override
    public Set<UsersShareOutput> getGroupBalancesForUsers(String groupId) throws Exception{
        Set<UsersShareOutput> result = new HashSet<>();
        Group group = getGroupById(groupId);
        Map<String, UsersShareRoot> usersShareRootMap = group.getUsersShareRootMap();
        UserService userService = UserServiceImpl.getInstance();

        for(Map.Entry<String, UsersShareRoot> rootEntry : usersShareRootMap.entrySet()){
            Map<String, UsersShareNode> usersShareNodeMap = rootEntry.getValue().getLinkedUsers();
            for(UsersShareNode nodeEntry : usersShareNodeMap.values()){
                User user1 = userService.getUserByUserId(nodeEntry.getUserId());
                User user2 = userService.getUserByUserId(rootEntry.getKey());
                if(nodeEntry.getUsersBalance() < 0)
                   result.add(new UsersShareOutput(user1.getName(), user2.getName(), -nodeEntry.getUsersBalance()));
                else
                    result.add(new UsersShareOutput(user2.getName(), user1.getName(), nodeEntry.getUsersBalance()));

            }
        }

        return result;


    }



}
