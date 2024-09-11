/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Service;

import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Err.EntityNotFoundException;
import com.example.UsersNews.Repo.UserJPA;
import com.example.UsersNews.Repo.UserRepo;
import com.example.UsersNews.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 *
 * @author esg88
 * 
 */
@Service
public class UserService implements UserRepo {

    @Autowired
private UserJPA userJPA;


    @Override
    public List<User> findAll() {
        return userJPA.findAll();
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
