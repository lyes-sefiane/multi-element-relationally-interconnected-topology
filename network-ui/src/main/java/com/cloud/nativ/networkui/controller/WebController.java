package com.cloud.nativ.networkui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 11:21 a.m.
 */
@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping(value = { "/", "/index" })
    public String getHomePage(Model model, Principal principal) {
        return "index";
    }
}
