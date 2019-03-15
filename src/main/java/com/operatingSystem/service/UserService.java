package com.operatingSystem.service;

import com.operatingSystem.model.User;

public interface UserService {
    public User getUserByIdAndPassword(User user) throws Exception;
}
