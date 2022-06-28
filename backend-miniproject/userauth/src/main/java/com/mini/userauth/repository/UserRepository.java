package com.mini.userauth.repository;

import com.mini.userauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findByEmailAndPassword(String username,String password);
}
