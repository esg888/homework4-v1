package web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CommentRequest {

    @NotNull(message = "ID  должно быть указано")
    @Positive(message = "ID должно быть больше 0!")
    private Integer commentaryId;

    @NotBlank(message = "Заполните текст коммента")
    private  String text;
}
