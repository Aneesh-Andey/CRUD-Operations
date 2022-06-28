package com.mini.usermovie.repository;

import com.mini.usermovie.entity.MovieUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<MovieUser,String> {
}
