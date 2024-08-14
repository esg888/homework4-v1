/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UsersNews.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author esg88
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "commentary")
public class Commentary {
    
              @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
          
     @Column(name = "text")
    private  String text;
     
           @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
           
                   @ManyToOne
    @JoinColumn(name ="item_id" )
            @ToString.Exclude
               private Item item;
    
}
