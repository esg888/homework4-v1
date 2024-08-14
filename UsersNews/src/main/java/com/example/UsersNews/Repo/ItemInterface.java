package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemInterface extends JpaRepository<Item, Integer> {
}
