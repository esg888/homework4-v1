package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Theme;
import com.example.UsersNews.different.PageFilter;

import java.util.List;

public interface ThemeRepo {

  //  List<Theme> findAll();
  List <Theme> findAll(PageFilter cp);
     Theme findById (Integer id);
     Theme save (Theme theme);
    Theme update (Theme theme);
    void delete (Integer id);}
