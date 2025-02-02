package com.example.javagyak;

import com.example.javagyak.lekerdezes.TablaGenerator;
import com.example.javagyak.login.User;
import com.example.javagyak.login.UserService;
import com.example.javagyak.messages.MsgDTO;
import com.example.javagyak.messages.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class FrontendController {



    private final UserService userService;
    private final MsgService messageService;
    @Autowired
    public FrontendController(UserService userService, MsgService msgService) {
        this.messageService = msgService;
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
    public String lekerdez(Model model) throws SQLException {
        TablaGenerator generator = new TablaGenerator();
        model.addAttribute("str", generator.getTableHtml());

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
    @GetMapping("/messages")
    public String viewMessages(Model model) {
        model.addAttribute("title", "Üzenetek");
        List<MsgDTO> messages = messageService.getLatestMessages(); // Csak a legfrissebb 10
        model.addAttribute("messages", messages);
        return "messages";
    }


}
