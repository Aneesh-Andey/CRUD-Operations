package com.mini.userauth.service;

import com.mini.userauth.entity.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTokengen implements TokenGen{
    @Override
    public Map<String, String> generateToken(User userobj) {
        String jsonwebtoken=null;
        JwtBuilder jwtBuilder= Jwts.builder();
        jsonwebtoken= jwtBuilder.setSubject(userobj.getName()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secret").compact();
Map<String,String> tokenmap= new HashMap<>();
tokenmap.put("token",jsonwebtoken);
tokenmap.put("message","success");

        return tokenmap;
    }
}
