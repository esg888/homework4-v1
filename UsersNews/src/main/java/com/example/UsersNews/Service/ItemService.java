package com.example.UsersNews.Service;

import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.Entity.Theme;
import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Err.EntityNotFoundException;
import com.example.UsersNews.Repo.ItemJPA;
import com.example.UsersNews.Repo.ItemRepo;
import com.example.UsersNews.util.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemRepo {

    private final ItemJPA itemJPA;
    private final UserService userService;
    private final ThemeService themeService;

    @Override
    public List<Item> findAll() {
        return itemJPA.findAll();
    }

    @Override
    public Item findById(Integer id) {
        return itemJPA.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Клиент с ID {0} не найден", id)));
    }

    @Override
    public Item save(Item item) {
        User user = userService.findById(item.getUser().getId());
        Theme theme = themeService.findById(item.getTheme().getId());
        item.setUser(user);
        item.setTheme(theme);
        return itemJPA.save(item);
    }

    @Override
    public Item update(Item item) {
        User user = userService.findById(item.getUser().getId());
        Theme theme = themeService.findById(item.getTheme().getId());
       Item eItem = findById(item.getId());
        BeanUtils.copyNonNullProperties(item, eItem);
        eItem.setUser(user);
        eItem.setTheme(theme);
        return itemJPA.save(eItem);
    }

    @Override
    public void delate(Integer id) { itemJPA.deleteById(id);}
}
