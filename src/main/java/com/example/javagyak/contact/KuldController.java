package com.example.javagyak.contact;

import com.example.javagyak.login.User;
import com.example.javagyak.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class KuldController {

    private final KuldService kuldService;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    public KuldController(KuldService kuldService) {
        this.kuldService = kuldService;
    }

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/contact/submit")
    public String submitContactForm(
            @RequestParam("message") String message,
            Model model,
            Principal principal // Bejelentkezett felhasználó információi
    ) {
        // Szerveroldali validáció
        if (message == null || message.isBlank()) {
            model.addAttribute("error", "Az üzenet mező nem lehet üres.");
            return "contact";
        }
        if (message.length() > 1000) {
            model.addAttribute("error", "Az üzenet nem lehet hosszabb, mint 1000 karakter.");
            return "contact";
        }

        // User azonosítása
        Integer userId = null; // Vendég alapértelmezés
        String username = null;

        if (principal != null) {
            username = principal.getName();
            Optional<User> user = userRepo.findByUsername(username);

            if (user.isPresent()) {
                userId = user.get().getId();
            }
        }

        // Adatbázis mentés
        boolean success = kuldService.saveMessage(username, message, userId);

        if (success) {
            model.addAttribute("success", "Az üzenet sikeresen elküldve.");
        } else {
            model.addAttribute("error", "Hiba történt az üzenet mentésekor.");
        }

        return "contact";
    }
}
