package com.example.GeneratePassword.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GeneratePasswordDTO {
    @NotNull(message = "Поле количество паролей не может быть пустым")
    @Min(value = 1, message = "Минимум 1 символов")
    @Max(value = 5, message = "Максимум 5 символа")
    private Byte countPassword;

    @NotNull(message = "Поле длина пароля не может быть пустым")
    @Min(value = 8, message = "Минимум 8 символов")
    @Max(value = 16, message = "Максимум 16 символа")
    private Byte countCharPassword;
}
