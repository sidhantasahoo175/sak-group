package com.sak.sakgroup.controller;

import com.sak.sakgroup.entity.User;
import com.sak.sakgroup.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.saveUser(user);
        return "redirect:/signup";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password, Model model) {

        User user = userService.loginUser(email, password);

        if (user != null) {
            model.addAttribute("username", user.getUsername());
            return "login-success";
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}