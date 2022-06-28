package com.mini.usermovie.proxy;

import com.mini.usermovie.entity.MovieUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( name = "USER-COMP")
public interface UserProductProxy {
    @PostMapping("/user/register")
    public ResponseEntity<String> register(@RequestBody MovieUser movieUser);


}
