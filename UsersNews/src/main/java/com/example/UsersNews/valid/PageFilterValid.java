package com.example.UsersNews.valid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FilterValidValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PageFilterValid {

    String message() default "Укажите корректные поля!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
