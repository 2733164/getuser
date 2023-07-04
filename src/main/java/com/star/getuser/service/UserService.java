package com.star.getuser.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.star.getuser.entity.User;
import org.springframework.beans.factory.annotation.Value;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface UserService {

    Object getCreateTime(String timeRange) throws JsonProcessingException;

    Map<String, Object> compare(@Value("month") String timeRange) throws ParseException;

    List<User> getAll();

    Map<String, Object> getSource();
}
