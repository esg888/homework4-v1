/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Controller;
import com.example.UsersNews.Entity.User;
import com.example.UsersNews.Mapper.UserMapper;
import com.example.UsersNews.Service.ThemeService;
import com.example.UsersNews.Service.UserService;
import com.example.UsersNews.web.UserListResponse;
import com.example.UsersNews.web.UserRequest;
import com.example.UsersNews.web.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


/**
 *
 * @author e.gruzinceva
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
        public class UserController {

private final UserMapper userMapper;
private final UserService userService;

        @GetMapping
        public ResponseEntity<UserListResponse> findAll(){
                List<User> users = userService.findAll();
                return ResponseEntity.ok(userMapper.userListResponseList(users));
                        }
        @GetMapping("/{id}")
        public ResponseEntity <UserResponse> findById(@PathVariable Integer id) {
                return ResponseEntity.ok(userMapper.userToResponse(userService.findById(id)));
                        }
        @PostMapping
        public  ResponseEntity <UserResponse> create (@RequestBody UserRequest request){
                User user = userService.save(userMapper.requestToUser(request));
                return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userToResponse(user));
                        }

        @PutMapping("/{id}")
        public ResponseEntity <UserResponse> update (@PathVariable("id")
                                                     Integer userId, @RequestBody UserRequest request){
                User upUser = userService.update(userMapper.requestToUser(userId, request));
                return ResponseEntity.ok(userMapper.userToResponse(upUser));
                    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id){
                userService.delete(id);
                return ResponseEntity.noContent().build();
        }
}
