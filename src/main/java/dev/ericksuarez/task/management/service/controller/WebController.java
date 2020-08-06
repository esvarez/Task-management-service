package dev.ericksuarez.task.management.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/swagger")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
