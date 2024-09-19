/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.UsersNews.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.UsersNews.Entity.Commentary;

/**
 *
 * @author e.gruzinceva
 */
@Repository
public interface CommentaryJPA extends JpaRepository<Commentary, Integer>, PagingAndSortingRepository<Commentary, Integer> {
  
    
}
