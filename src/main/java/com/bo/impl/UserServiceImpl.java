package com.bo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bo.mapper.UserMapper;
import com.bo.pojo.User;
import com.bo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> selectHistory() {
        return userMapper.selectList(null);
    }

    @Override
    public List<User> selectNew() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .orderByDesc("id")
                .last("limit 1");

        return userMapper.selectList(wrapper);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delUserById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int recover(String name) {
        return userMapper.recover(name);
    }
}
