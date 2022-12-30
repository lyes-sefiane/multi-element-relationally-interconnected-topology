package com.cloud.nativ.graphnetworkcommand.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-12-29 1:04 p.m.
 */
@RestController
public class testRestController {

    @GetMapping("/")
    public String home(){
        return "Hola!";
    }
}
