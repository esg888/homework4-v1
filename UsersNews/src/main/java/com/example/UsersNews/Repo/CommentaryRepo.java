package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Commentary;
import com.example.UsersNews.different.PageFilter;

import java.util.List;

public interface CommentaryRepo {

//    List<Commentary> findAll();
List<Commentary> findAll(PageFilter cp);
    Commentary findById(Integer id);
    Commentary save (Commentary commentary);
    Commentary update (Commentary commentary);
    void deleteById(Integer id);

}
