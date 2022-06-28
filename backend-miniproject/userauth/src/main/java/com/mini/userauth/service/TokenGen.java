package com.mini.userauth.service;

import com.mini.userauth.entity.User;

import java.util.Map;

public interface TokenGen {
    Map<String,String> generateToken(User userobj);
}
