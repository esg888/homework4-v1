package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ThemeJPA extends JpaRepository<Theme, Integer>, PagingAndSortingRepository<Theme, Integer> {
}
