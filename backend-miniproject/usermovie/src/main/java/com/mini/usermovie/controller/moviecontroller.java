package com.mini.usermovie.controller;

import com.mini.usermovie.entity.Movie;
import com.mini.usermovie.entity.MovieUser;
import com.mini.usermovie.service.movieservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieuser")
//@CrossOrigin
public class moviecontroller {
    @Autowired
    movieservice movieserviceobj;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MovieUser movieUser)
    {
        System.out.println("in movie user controller");
        return new ResponseEntity<>(movieserviceobj.save(movieUser), HttpStatus.CREATED);

    }
    @GetMapping("/getdata/{email}")
    public  ResponseEntity<?> getdata(@PathVariable String email){
        return new  ResponseEntity<>(movieserviceobj.getdata(email),HttpStatus.OK);
    }

    @PostMapping("/senddata/{email}")
    public  ResponseEntity<?> send(@RequestBody Movie movie,@PathVariable String email)
    {
        return  new ResponseEntity<>(movieserviceobj.addmovie(movie,email),HttpStatus.OK);
    }
    @PostMapping("/delete/{email}")
    public  ResponseEntity<?> delete(@RequestBody Movie movie,@PathVariable String email)
    {
        return new ResponseEntity<>(movieserviceobj.deletemovie(email,movie),HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updating(@RequestBody MovieUser movieUser)
    {
        System.out.println("in movie user controller");
        return new ResponseEntity<>(movieserviceobj.update(movieUser), HttpStatus.CREATED);

    }

}
