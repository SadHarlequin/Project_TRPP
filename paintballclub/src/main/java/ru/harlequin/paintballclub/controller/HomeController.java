package ru.harlequin.paintballclub.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
    String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
    if (role == "[ROLE_ADMIN]"){
        String url = "url";
        model.addAttribute("url",url);
        }
        return "home";
    }

    @GetMapping("/registration")
    public String reg(){
        return "registration";
    }
}
