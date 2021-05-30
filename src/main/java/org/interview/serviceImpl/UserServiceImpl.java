package org.interview.serviceImpl;

import org.interview.model.User;
import org.interview.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserService instance = new UserServiceImpl();

    private List<User> users;

    private UserServiceImpl() {
        users = new ArrayList<>();
    }

    @Override
    public String addNewUser(String userName){
        User newUser = new User(userName);
        users.add(newUser);
        System.out.println("User added "+newUser);
        return newUser.getId();
    }

    public User getUserByUserId(String userId) throws Exception{
        for(User user : users){
            if(user.getId().equals(userId)) {
                return user;
            }
        }
        throw new Exception("User does not exist for id"+userId);
    }

    public void validateUserById(String userId) throws Exception{
        getUserByUserId(userId);
    }


    public static UserService getInstance(){
        return instance;
    }
}
