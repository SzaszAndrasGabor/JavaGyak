package com.example.javagyak;

import com.example.javagyak.login.User;
import com.example.javagyak.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FrontendController {



    private final UserService userService;

    @Autowired
    public FrontendController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Főoldal");
        return "index"; // Az index.html-t tölti be a templates mappából
    }



    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Kapcsolat");
        model.addAttribute("authentication", null);
        return "contact";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @GetMapping("/lekerdez")
    public String lekerdez(Model model) {
        model.addAttribute("user", new User());
        return "lekerdez";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            userService.registerUser(user.getUsername(), user.getEmail(),user.getPassword(), user.getConfirmPassword());
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }


}
