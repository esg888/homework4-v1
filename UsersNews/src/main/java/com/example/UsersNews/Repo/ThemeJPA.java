package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeJPA extends JpaRepository<Theme, Integer> {
}
