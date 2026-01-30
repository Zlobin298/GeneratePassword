package com.example.GeneratePassword.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GeneratePasswordDTO {
    @NotBlank(message = "Поле количество паролей не может быть пустым")
    @Size(min = 1, max = 5, message = "Укажите допустимый диапазон")
    private String countPassword;

    @NotBlank(message = "Поле длина пароля не может быть пустым")
    @Size(min = 8, max = 8, message = "Укажите допустимый диапазон")
    private String countCharPassword;
}
