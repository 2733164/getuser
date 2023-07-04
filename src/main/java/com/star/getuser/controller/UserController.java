package com.star.getuser.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.star.getuser.common.Result;
import com.star.getuser.entity.User;
import com.star.getuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public String getUser(){
        return "user.html";
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getCreateTime/{timeRange}")
    public Result getCreateTime(@PathVariable String timeRange) throws JsonProcessingException {
        return Result.success(userService.getCreateTime(timeRange));
    }

    @GetMapping("/compare")
    public Result compare() throws ParseException {
        return Result.success(userService.compare("month"));
    }

    @GetMapping("/getSource")
    public Result getSource() throws ParseException {
        return Result.success(userService.getSource());
    }
}
