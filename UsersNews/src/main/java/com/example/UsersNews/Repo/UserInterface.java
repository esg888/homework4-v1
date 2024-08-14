/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.UsersNews.Repo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esg88
 */
@Repository
        public interface UserInterface extends  JpaRepository  <User, Integer> {
    
    
}
