package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Commentary;
import java.util.List;

public interface CommentaryRepo {

    List<Commentary> findAll();
    Commentary findById(Integer id);
    Commentary save (Commentary commentary);
    Commentary update (Commentary commentary);
    void deleteById(Integer id);

}
