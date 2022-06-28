package com.mini.usermovie.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieUser {
    @Id
    String email;
    String name;
    @Transient
    String password;
    List<Movie> movie;
}
