/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Service;

import com.example.UsersNews.Entity.Commentary;
import com.example.UsersNews.Repo.CommentaryInterface;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author e.gruzinceva
 */
@Service
@RequiredArgsConstructor
public class CommentaryService implements CommentaryInterface {
    
   @Autowired
   private CommentaryInterface commentatyInterface;


   @Override
   public List<Commentary> findAll() {
      return List.of();
   }

    @Override
    public <S extends Commentary> S save(S entity) {
        return null;
    }

    @Override
   public void deleteById(Integer integer) {

   }

    @Override
    public Optional<Commentary> findById(Integer integer) {
        return Optional.empty();
    }


}
