package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Theme;

import java.util.List;

public interface ThemeRepo {

    List<Theme> findAll();
     Theme findById (Integer id);
     Theme save (Theme theme);
    Theme update (Theme theme);
    void delete (Integer id);}
