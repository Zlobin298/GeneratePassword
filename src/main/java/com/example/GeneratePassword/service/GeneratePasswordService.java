package com.example.GeneratePassword.service;

import com.example.GeneratePassword.dto.GeneratePasswordDTO;

import java.util.List;

public interface GeneratePasswordService {
    String generatePassword(GeneratePasswordDTO dto);
    List<String> history();
    void save();
}
