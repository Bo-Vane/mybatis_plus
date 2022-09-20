package com.bo;

import com.bo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Mytest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDel(){
        System.out.println(userMapper.selectById(1));

    }
}
