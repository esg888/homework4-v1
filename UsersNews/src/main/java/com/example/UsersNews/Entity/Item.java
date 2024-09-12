/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ekaterina
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "item")
public class Item {
    
          @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
          
     @Column(name = "details")
    private  String details;

      @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
      @JsonIgnore
    private User user;


      
        @ManyToOne
    @JoinColumn(name ="theme_id" )
            @ToString.Exclude
        @JsonIgnore
        private Theme theme;
        
              @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
     private List<Commentary>  commentarys = new ArrayList<>();
  
}
