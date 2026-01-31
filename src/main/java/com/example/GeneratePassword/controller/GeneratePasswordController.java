package com.example.GeneratePassword.controller;

import com.example.GeneratePassword.dto.GeneratePasswordDTO;
import com.example.GeneratePassword.service.GeneratePasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class GeneratePasswordController {
    private final GeneratePasswordService service;

    @GetMapping("/home")
    public String home(Model model) {
        try {
            model.addAttribute("password", service.getPassword());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        return "index";
    }

    @PostMapping("/generatePassword")
    public String generatePassword(@Valid GeneratePasswordDTO dto) {
        service.generatePassword(dto);

        return "redirect:/home";
    }

    @PostMapping("/history")
    public String history(Model model) {
        List<List<String>> history = service.history();
        List<String> list = new ArrayList<>();

        for (List<String> el : history) {
            for (String j : el) {
                list.add(j);
            }
        }

        model.addAttribute("historyList", list);

        return "index";
    }
}
