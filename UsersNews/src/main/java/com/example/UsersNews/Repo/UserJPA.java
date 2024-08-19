/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.UsersNews.Repo;
import com.example.UsersNews.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esg88
 */
@Repository
        public interface UserJPA extends  JpaRepository  <User, Integer> {
    
    
}
