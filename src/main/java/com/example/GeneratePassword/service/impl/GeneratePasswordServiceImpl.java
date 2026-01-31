package com.example.GeneratePassword.service.impl;

import com.example.GeneratePassword.dto.GeneratePasswordDTO;
import com.example.GeneratePassword.service.GeneratePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneratePasswordServiceImpl implements GeneratePasswordService {
    private final List<List<String>> list;
    public StringBuilder password;

    @Override
    public String generatePassword(GeneratePasswordDTO dto) {
        password = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom rn = new SecureRandom();
        List<String> list1 = new LinkedList<>();

        for (byte i = 0; i < dto.getCountPassword(); i++) {
            for (byte j = 0; j < dto.getCountCharPassword(); j++) {
                int index = rn.nextInt(chars.length());
                password.append(chars.charAt(index));
            }

            list1.add(password.toString());
            password = new StringBuilder();
        }

        list.add(list1);

        return password.toString();
    }

    @Override
    public List<List<String>> history() {
        return list;
    }

    @Override
    public List<String> getPassword() {
        return list.get(list.size() - 1);
    }
}
