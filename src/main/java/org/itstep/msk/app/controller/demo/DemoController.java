package org.itstep.msk.app.controller.demo;

import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/")
public class DemoController {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    public String demo(Model model, @RequestParam(defaultValue = "1") String name) {
        System.out.println(passwordEncoder.encode("123456"));
        model.addAttribute("name", name);
        System.out.println(name);

        return "demo";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/registration") // http://localhost:9999/registration?same=true
    public String registration(@RequestParam(defaultValue = "false") String same, Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) throws Exception {
        return "redirect:/login";
    }


}
