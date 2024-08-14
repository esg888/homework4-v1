/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
          
     @Column(name = "deatails")
    private  String deatails;

      @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
      
        @ManyToOne
    @JoinColumn(name ="theme_id" )
            @ToString.Exclude
        private Theme theme;
        
              @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
     private List<Commentary>  commentarys = new ArrayList<>();
  
}
