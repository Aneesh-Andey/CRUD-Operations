package com.mini.userauth.service;

import com.mini.userauth.entity.User;
import com.mini.userauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepositoryobj;

    public String saveUser(User user)
    {
        System.out.println("inside the user service");
        userRepositoryobj.save(user);
        return "created";
    }
    public List<?> getallUserData(){
return userRepositoryobj.findAll();
    }
public User loginuser(String username,String password) throws Exception {
User userobj=userRepositoryobj.findByEmailAndPassword(username,password);
if(userobj==null)
{
    throw new Exception();
}
else
{
return userobj;
}
}
}
