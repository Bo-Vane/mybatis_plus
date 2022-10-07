package com.bo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    //通过name恢复数据
    int recover(String name);
}
