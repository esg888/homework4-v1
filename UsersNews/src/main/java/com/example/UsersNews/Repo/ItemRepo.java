package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Item;

import java.util.List;

public interface ItemRepo {

List<Item> findAll();

Item findById (Integer id);

Item save (Item item);

Item update (Item item);

void delate (Integer id);

}
