package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.User;

import java.util.List;

public interface UserRepo {

    List<User> findAll();
    User findById(Integer id);
    User save (User user);
    User update (User user);
    void delete (Integer id);
}
