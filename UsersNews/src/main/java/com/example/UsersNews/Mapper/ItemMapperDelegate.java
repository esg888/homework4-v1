package com.example.UsersNews.Mapper;

import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.Repo.ThemeRepo;
import com.example.UsersNews.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.UsersNews.web.ItemRequest;

public abstract class  ItemMapperDelegate implements ItemMapper{
    @Autowired
    UserRepo userRepo;

    @Autowired
    ThemeRepo themeRepo;

    @Override
    public Item requestToItem(Integer id, ItemRequest itemRequest) {
        Item item = requestToItem(itemRequest);
        item.setId(id);
        return item;
    }

    @Override
    public Item requestToItem(ItemRequest itemRequest) {
        Item item = new Item();
        item.setDetails(itemRequest.getDetails());
        item.setUser(userRepo.findById(itemRequest.getUserId()));
        item.setTheme(themeRepo.findById(itemRequest.getThemeId()));
        return item;
    }
}
