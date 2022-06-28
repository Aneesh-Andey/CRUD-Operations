package com.mini.usermovie.service;

import com.mini.usermovie.entity.Movie;
import com.mini.usermovie.entity.MovieUser;
import com.mini.usermovie.proxy.UserProductProxy;
import com.mini.usermovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class movieservice {
    UserProductProxy userProductProxy;
    MovieRepository movieRepositoryobj;

    @Autowired

public movieservice(UserProductProxy userProductProxy,MovieRepository movieRepositoryobj)
{
    this.userProductProxy=userProductProxy;
    this.movieRepositoryobj=movieRepositoryobj;
}

    public MovieUser save(MovieUser movieUser)
    {
//        System.out.println("movie user service above the prxoy calling");
     ResponseEntity r= userProductProxy.register(movieUser);
//        System.out.println(r.getBody());
        System.out.println("movie user service after  the prxoy calling");

      return   movieRepositoryobj.save(movieUser);

    }
    public Optional<MovieUser> getdata(String email)
    {
        return movieRepositoryobj.findById(email);
    }
    public  Movie addmovie(Movie movie, String email)
    {
        Optional<MovieUser> movieUser=movieRepositoryobj.findById(email);
        System.out.println(movieUser.get());
        if(movieUser.isPresent()) {
            if(movieUser.get().getMovie()==null)
            {
                List<Movie> movies=new ArrayList<>();
                movies.add(movie);
                movieUser.get().setMovie(movies);
                movieRepositoryobj.save(movieUser.get());
            }else {
                movieUser.get().getMovie().add(movie);
                movieRepositoryobj.save(movieUser.get());
            }

//            List<Movie> movies=movieUser.get().getMovie();
//            movies.add(movie);
//            movieUser.get().setMovie(movies);

        }

        return movie;
    }
    public Movie deletemovie(String email,Movie movie)
    {
       // System.out.println("in");
        Optional<MovieUser> movieUser=movieRepositoryobj.findById(email);
      List<Movie> movieobj=  movieUser.get().getMovie();
//        System.out.println(movieUser);
//        System.out.println(movieobj);
//        for (int i=0;i< movieobj.size();i++) {
//            System.out.println(movieobj.get(i).getMoviename().equalsIgnoreCase(movie.getMoviename()));
//            System.out.println(movieobj.get(i).getMoviename());
//        }
        for (int i=0;i< movieobj.size();i++) {
            if (movieobj.get(i).getMoviename().equalsIgnoreCase(movie.getMoviename())) {
              //  System.out.println("end");
                Movie index = movieobj.get(i);
                System.out.println(index);
                 movieUser.get().getMovie().remove(index);
                 movieRepositoryobj.save(movieUser.get());

            }
        }
          return movie;
    }
    public Movie edit(String email,Movie movie)
    {
        Optional<MovieUser> movieUser=movieRepositoryobj.findById(email);
        if(movieUser.isPresent())
        {
            movieUser.get().getMovie().add(movie);
            movieRepositoryobj.save(movieUser.get());
        }
        return null;
    }

    public MovieUser update(MovieUser movieUser)
    {
        return   movieRepositoryobj.save(movieUser);

    }
}
