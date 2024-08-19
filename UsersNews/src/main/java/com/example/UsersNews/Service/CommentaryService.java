/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Service;

import com.example.UsersNews.Entity.Commentary;
import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Repo.CommentaryJPA;
import com.example.UsersNews.Repo.CommentaryRepo;
import com.example.UsersNews.Repo.ItemRepo;
import com.example.UsersNews.Repo.UserRepo;
import com.example.UsersNews.util.BeanUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 *
 * @author e.gruzinceva
 */
@Service
@RequiredArgsConstructor
public class CommentaryService implements CommentaryRepo {

    private final CommentaryJPA commentaryJPA;
    private  final ItemRepo itemRepo;
    private final UserRepo userRepo;

    @Override
    public List<Commentary> findAll() {
        return commentaryJPA.findAll();
    }

    @Override
    public Commentary findById(Integer id) {
        return commentaryJPA.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("ID {0} не найден", id)));
    }

    @Override
    public Commentary save(Commentary commentary) {
Item item = itemRepo.findById(commentary.getItem().getId());
User user = userRepo.findById(commentary.getUser().getId());
commentary.setItem(item);
        commentary.setUser(user);
        return commentaryJPA.save(commentary);
    }

    @Override
    public Commentary update(Commentary commentary) {
        Item item = itemRepo.findById(commentary.getItem().getId());
        User user = userRepo.findById(commentary.getUser().getId());
        Commentary ecomment = findById(commentary.getId());
        BeanUtils.copyNonNullProperties(commentary, ecomment);
        ecomment.setUser(user);
        ecomment.setItem(item);
        return commentaryJPA.save(ecomment);
    }

    @Override
    public void deleteById(Integer id) {
        commentaryJPA.deleteById(id);
    }
}
