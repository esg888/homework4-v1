package web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    @NotBlank(message = "Заполните новость!")
    @Size(min = 3, max = 333, message = "новость не может быть меньше {min} и больше {max}!")
    private String details;
}
