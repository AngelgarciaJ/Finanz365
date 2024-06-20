package com.pronabc.finanz.controller;

import com.pronabc.finanz.model.User;
import com.pronabc.finanz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam String role) {
        switch (role.toLowerCase()) {
            case "student":
                return "student/dashboard";
            case "coordinator":
                return "coordinator/dashboard";
            case "admin":
                return "admin/dashboard";
            default:
                return "redirect:/";
        }
    }
}

