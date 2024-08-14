package com.example.UsersNews.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.NoArgsConstructor;

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
@Entity(name = "theme")
public class Theme {
      
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
     @Column(name = "subject")
    private String subject;
          
        @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default  
private List<Item> items = new ArrayList<>();
        
}
