/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Service;

import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Err.EntityNotFoundException;
import com.example.UsersNews.Repo.UserJPA;
import com.example.UsersNews.Repo.UserRepo;
import com.example.UsersNews.different.PageFilter;
import com.example.UsersNews.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.text.MessageFormat;

/**
 *
 * @author esg88
 * 
 */
@Service
public class UserService implements UserRepo {

    @Autowired
private UserJPA userJPA;


//    @Override
//    public List <User> findAll(){
//        return
//        userJPA.findAllUsers(PageRequest.of(0, 2)).getContent();
//    }


//    @Override
//    public List <User> findAll(Integer n, Integer s){
//        Pageable paging = PageRequest.of(n, s);
//        Page<User> p = userJPA.findAll(paging);
//        return p.getContent();
//    }
    @Override
    public List <User> findAll(PageFilter cp){
        Integer n = cp.getNum();
        Integer s = cp.getSize();
        Pageable paging = PageRequest.of(n, s);
        Page<User> p = userJPA.findAll(paging);
        return p.getContent();
    }


    @Override
    public User findById(Integer id) {
        return userJPA.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("ID {0} не найден", id)));
    }

    @Override
    public User save(User user) {
            return userJPA.save(user);
    }

    @Override
    public User update(User user) {
        User eUser = findById(user.getId());
        BeanUtils.copyNonNullProperties(user, eUser);
        return userJPA.save(eUser);
    }

    @Override
    public void delete(Integer id) { userJPA.deleteById(id);

    }
}
