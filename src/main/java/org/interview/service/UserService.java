package org.interview.service;

import org.interview.model.User;

public interface UserService {

    public String addNewUser(String userName);

    public User getUserByUserId(String userId) throws Exception;




}
