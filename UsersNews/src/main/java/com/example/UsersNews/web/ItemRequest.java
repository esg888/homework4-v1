package com.example.UsersNews.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

    @NotNull(message = "ID  должно быть указано")
    @Positive(message = "ID должно быть больше 0!")
    private Integer themeId;

    @NotNull(message = "ID  должно быть указано")
    @Positive(message = "ID должно быть больше 0!")
    private Integer userId;

    @NotBlank(message = "Заполните новость!")
    @Size(min = 3, max = 333, message = "новость не может быть меньше {min} и больше {max}!")
    private String details;
}
