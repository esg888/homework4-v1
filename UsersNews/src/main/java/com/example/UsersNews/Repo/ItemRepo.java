package com.example.UsersNews.Repo;

import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.different.PageFilter;

import java.util.List;

public interface ItemRepo {

//List<Item> findAll();
List<Item> findAll(PageFilter pageFilter);

    List<Item> findFilter(PageFilter pageFilter);

Item findById (Integer id);

Item save (Item item);

Item update (Item item);

void delete (Integer id);

}
