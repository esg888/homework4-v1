package com.example.UsersNews.Service;

import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.Entity.Theme;
import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Err.CheckUserException;
import com.example.UsersNews.Err.EntityNotFoundException;
import com.example.UsersNews.Repo.ItemJPA;
import com.example.UsersNews.Repo.ItemRepo;
import com.example.UsersNews.Repo.ItemSpecification;
import com.example.UsersNews.different.PageFilter;
import com.example.UsersNews.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.UsersNews.aop.CheckingIt;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemsService implements ItemRepo {

    @Autowired
    private final ItemJPA itemJPA;
    @Autowired
    private final UserService userService;
    @Autowired
    private final ThemeService themeService;

//    @Override
//    public List<Item> findAll() {
//        return itemJPA.findAll();
//    }

    @Override
    public List<Item> findAll(PageFilter pageFilter){
        Integer n = pageFilter.getNum();
        Integer s = pageFilter.getSize();
        Pageable paging = PageRequest.of(n, s);
        Page<Item> p = itemJPA.findAll(paging);
        return p.getContent();
    }

    @Override
    public List<Item> findFilter(PageFilter pageFilter) {
        return itemJPA.findAll(ItemSpecification.withFilter(pageFilter),
                PageRequest.of(
                        pageFilter.getNum(), pageFilter.getSize()
                )).getContent();
    }

    @Override
    public Item findById(Integer id) {
        return itemJPA.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("ID {0} не найден", id)));
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
    @CheckingIt
    public Item update(Item item, Integer ownerId) {
        User user = userService.findById(item.getUser().getId());
        Theme theme = themeService.findById(item.getTheme().getId());
       Item eItem = findById(item.getId());
        BeanUtils.copyNonNullProperties(item, eItem);
        eItem.setUser(user);
        eItem.setTheme(theme);
        return itemJPA.save(eItem);
    }



    @Override
   @CheckingIt
    public void delete(Integer itemId, Integer ownerId) {
            itemJPA.deleteById(itemId);}

    @Override
    public void checkIt(Integer itemId, Integer ownerId) {

       Item item = findById(itemId);
        User user = item.getUser();
        Integer userId = user.getId();
         if(!Objects.equals(ownerId, userId)){
            throw new CheckUserException("Нельзя удалять чужие новости");
        }
    }

    @Override
    public  void CheckUpd (Item item, Integer ownerId)
    {
        User user = item.getUser();
        Integer userId = user.getId();
        if(!Objects.equals(ownerId, userId)){
            throw new CheckUserException("Нельзя править чужие новости");
        }
    }


}
