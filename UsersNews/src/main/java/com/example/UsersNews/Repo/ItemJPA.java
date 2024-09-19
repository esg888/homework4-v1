package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemJPA extends JpaRepository<Item, Integer>, PagingAndSortingRepository<Item, Integer>, JpaSpecificationExecutor<Item> {
}
