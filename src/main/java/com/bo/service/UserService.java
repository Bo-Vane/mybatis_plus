package com.bo.service;

import com.bo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectHistory();

    List<User> selectNew();

    int addUser(User user);

    int delUserById(int id);

    int recover(String name);
}
