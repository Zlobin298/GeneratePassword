package com.example.GeneratePassword;

import com.example.GeneratePassword.dto.GeneratePasswordDTO;
import com.example.GeneratePassword.service.impl.GeneratePasswordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeneratePasswordApplicationTests {
    private GeneratePasswordServiceImpl service;
    private List<List<String>> internalList;

    @BeforeEach
    void setUp() {
        internalList = new ArrayList<>();
        service = new GeneratePasswordServiceImpl(internalList);
    }

    @Test
    @DisplayName("Должен генерировать пароли с правильными параметрами")
    void generatePassword_Success() {
        GeneratePasswordDTO dto = new GeneratePasswordDTO();
        dto.setCountPassword((byte) 3);
        dto.setCountCharPassword((byte) 12);

        service.generatePassword(dto);

        assertEquals(1, internalList.size(), "В истории должна появиться одна запись (пачка паролей)");
        List<String> lastGenerated = internalList.get(0);

        assertEquals(3, lastGenerated.size(), "Должно быть сгенерировано 3 пароля");
        assertEquals(12, lastGenerated.get(0).length(), "Длина пароля должна быть 12 символов");

        assertNotEquals(lastGenerated.get(0), lastGenerated.get(1), "Пароли должны быть случайными и разными");
    }

    @Test
    @DisplayName("Метод history() должен возвращать весь список накопленных паролей")
    void history_ShouldReturnAllData() {
        internalList.add(List.of("pass1", "pass2"));
        internalList.add(List.of("pass3", "pass4"));

        List<List<String>> result = service.history();

        assertEquals(2, result.size());
        assertEquals("pass1", result.get(0).getFirst());
        assertEquals("pass4", result.get(1).get(1));
    }

    @Test
    @DisplayName("getPassword() должен возвращать только последнюю сгенерированную группу паролей")
    void getPassword_ShouldReturnLastEntry() {
        GeneratePasswordDTO dto1 = new GeneratePasswordDTO();
        dto1.setCountPassword((byte) 1);
        dto1.setCountCharPassword((byte) 8);

        GeneratePasswordDTO dto2 = new GeneratePasswordDTO();
        dto2.setCountPassword((byte) 2);
        dto2.setCountCharPassword((byte) 10);

        service.generatePassword(dto1);
        service.generatePassword(dto2);

        List<String> result = service.getPassword();

        assertEquals(2, result.size(), "Должно вернуться 2 пароля из последней генерации");
        assertEquals(10, result.getFirst().length(), "Длина пароля должна соответствовать последнему запросу");
    }

    @Test
    @DisplayName("Должен бросать исключение при попытке получить пароль из пустой истории")
    void getPassword_EmptyList_ThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> service.getPassword(), "Если список пуст, должен выбросить исключение (стандартное поведение List.get)");
    }
}
