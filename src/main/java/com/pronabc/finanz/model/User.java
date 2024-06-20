package com.pronabc.finanz.model;

// package com.finanz365.model;

import org.springframework.data.relational.core.mapping.Column;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    // Getters and Setters
}

