package com.operatingSystem.dao;

import com.operatingSystem.model.User;

public interface UserMapper {
   public User getUserByIdAndPassword(User user);
}
