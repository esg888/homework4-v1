/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Controller;

import com.example.UsersNews.Repo.UserJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Page;
import com.example.UsersNews.Entity.User;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.PageRequest;



/**
 *
 * @author e.gruzinceva
 */
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
        public class UserController {
    
    private final UserJPA userInterface;
    
    @GetMapping
    public Page <User> getAll(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam (value = "limit", defaultValue = "20") Integer limit
    )
    {
        return  userInterface.findAll(PageRequest.of(offset, limit));
    }
        
    
    
}
