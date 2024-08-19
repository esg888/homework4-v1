package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJPA extends JpaRepository<Item, Integer> {
}
