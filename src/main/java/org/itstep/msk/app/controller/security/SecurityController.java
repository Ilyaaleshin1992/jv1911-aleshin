package org.itstep.msk.app.controller.security;


import org.itstep.msk.app.entity.Account;
import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.entity.modelFormApplication.ModelFormPassport;
import org.itstep.msk.app.entity.enums.Role;
import org.itstep.msk.app.entity.modelFormApplication.ModelFormPassport;
import org.itstep.msk.app.repository.AccountRepository;
import org.itstep.msk.app.repository.UserRepository;
import org.itstep.msk.app.repository.modelFormApplicationRepository.ModelFormPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SecurityController {

    @Autowired
    ModelFormPassportRepository modelFormPassportRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration (){
        return "/security/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute User user) {
        User u = userRepository.findByUsername(user.getUsername());
        if (u != null) {
            return "redirect:/registration";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepository.saveAndFlush(user);
        userRepository.findByUsername(user.getUsername()).getId();
        Account account = new Account();
        account.setOwner(userRepository.findByUsername(user.getUsername()));
        accountRepository.saveAndFlush(account);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "/security/login";
    }


    @RequestMapping(value="/personalDataForm", method= RequestMethod.POST)
    private String personalDataForm(
            @ModelAttribute ModelFormPassport form) {
        if(form !=null) {
            modelFormPassportRepository.saveAndFlush(form);
            return "redirect:/";
        }
        return "redirect:/";
    }
}
