package com.example.UsersNews.web;

import com.example.UsersNews.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeResponse {
    private int id;
    private String subject;
    private List<Item> items = new ArrayList<>();
}
