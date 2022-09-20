package com.bo.controller;

import com.bo.impl.UserServiceImpl;
import com.bo.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class BootController {

    private final UserServiceImpl userService;

    public BootController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/add")
    public String add(String name,int age,String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return "增加了"+userService.addUser(user)+"条数据";
    }

    @RequestMapping("/history")
    public String queryHistory() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(userService.selectHistory());
        return "历史记录"+s;
    }

    @RequestMapping("/get")
    public  String queryNew() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(userService.selectNew());
        return "刚刚的数据："+s;
    }

    @RequestMapping("/del")
    public String delById(int id){
        return "删除了"+userService.delUserById(id)+"行数据";
    }
}
