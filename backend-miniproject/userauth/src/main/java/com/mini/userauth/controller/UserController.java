package com.mini.userauth.controller;

import com.mini.userauth.entity.User;
import com.mini.userauth.service.JWTokengen;
import com.mini.userauth.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userServiceobj;
    @Autowired
    JWTokengen jwTokengen;

//    @CrossOrigin("http://localhost:4200")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        System.out.println("user controller");
        return new ResponseEntity<String>(userServiceobj.saveUser(user), HttpStatus.CREATED);

    }
    @GetMapping("/getusers")
    public  ResponseEntity<?> getalldata()
    {
        return  new ResponseEntity<>(userServiceobj.getallUserData(),HttpStatus.OK);
    }
    @PostMapping("/login")
    //@CrossOrigin("http://localhost:4200")
    @HystrixCommand(fallbackMethod = "fallbacklogin")
    @HystrixProperty(name =  "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception {
       // Thread.sleep(3000);
          User userobj=userServiceobj.loginuser(user.getEmail(), user.getPassword());
          ResponseEntity<?> responseEntity;

        if (user.getEmail().equalsIgnoreCase(userobj.getEmail()))
        {
            Map<String,String> token=jwTokengen.generateToken(userobj);
            responseEntity= new  ResponseEntity<>(token,HttpStatus.OK);

        }else
        {
            responseEntity=new ResponseEntity<>("*****Error Occuered******",HttpStatus.BAD_REQUEST);
        }
        return  responseEntity;
    }
    public ResponseEntity<?> fallbacklogin(@RequestBody User user)
    {
        return new ResponseEntity<>("login failed",HttpStatus.BAD_GATEWAY);
    }


}
