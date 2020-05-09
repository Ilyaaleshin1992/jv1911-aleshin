package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.modelFormApplication.ModelFormPassport;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String demo(Model model) {
        ModelFormPassport form = new ModelFormPassport();
        model.addAttribute("form",form);
        return "index";
    }

}
