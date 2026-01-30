package com.example.GeneratePassword.controller;

import com.example.GeneratePassword.dto.GeneratePasswordDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GeneratePasswordController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @PostMapping("/generatePassword")
    public String generatePassword(@Valid GeneratePasswordDTO dto) {
        return "redirect:/home";
    }

    @PostMapping("/history")
    public String history() {
        return "redirect:/home";
    }
}
