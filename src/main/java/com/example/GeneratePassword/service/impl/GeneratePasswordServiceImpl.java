package com.example.GeneratePassword.service.impl;

import com.example.GeneratePassword.dto.GeneratePasswordDTO;
import com.example.GeneratePassword.service.GeneratePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneratePasswordServiceImpl implements GeneratePasswordService {
    private final List<String> list;
    private static final StringBuilder password = new StringBuilder();

    @Override
    public String generatePassword(GeneratePasswordDTO dto) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom rn = new SecureRandom();

        for (byte i = 0; i < Byte.parseByte(dto.getCountPassword()); i++) {
            for (byte j = 0; j < Byte.parseByte(dto.getCountCharPassword()); j++) {
                int index = rn.nextInt(chars.length());
                password.append(chars.charAt(index));
            }
        }

        return password.toString();
    }

    @Override
    public void save() {
        list.add(password.toString());
    }

    @Override
    public List<String> history() {
        return list;
    }
}
