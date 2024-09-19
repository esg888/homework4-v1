package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.User;
import com.example.UsersNews.different.PageFilter;

import java.util.List;

public interface UserRepo {

 //  List<User> findAll();

    List <User> findAll(PageFilter cp);

    User findById(Integer id);
    User save (User user);
    User update (User user);
    void delete (Integer id);

}
