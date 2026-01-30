package com.example.GeneratePassword.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "link", schema = "public")
public class GeneratePassword {
    @Id
    @Column(name = "count_password", nullable = false)
    private String countPassword;

    @Column(name = "count_char_password", nullable = false)
    private String countCharPassword;
}
