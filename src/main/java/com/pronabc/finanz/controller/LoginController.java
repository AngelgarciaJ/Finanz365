package com.pronabc.finanz.controller;

//package com.finanz365.controller;

import com.pronabc.finanz.model.User;
import com.pronabc.finanz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Aquí puedes redirigir al usuario a diferentes vistas según su rol
            switch (user.getRole()) {
                case "ESTUDIANTE":
                    return "redirect:/estudiante/dashboard";
                case "COORDINADOR":
                    return "redirect:/coordinador/dashboard";
                case "ADMIN":
                    return "redirect:/admin/dashboard";
                default:
                    model.addAttribute("error", "Rol desconocido");
                    return "login";
            }
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}

