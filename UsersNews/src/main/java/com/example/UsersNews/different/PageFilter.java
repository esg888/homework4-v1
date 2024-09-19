package com.example.UsersNews.different;

import com.example.UsersNews.valid.PageFilterValid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@PageFilterValid
public class PageFilter {

    private Integer num;
    private Integer size;
private Integer userId;
    private Integer themeId;

}
