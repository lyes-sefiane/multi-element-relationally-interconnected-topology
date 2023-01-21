package com.cloud.nativ.networkui.controller;

import com.cloud.nativ.networkui.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 2:11 p.m.
 */
@Controller
@RequestMapping("/network-elements")
public class NetworkElementsController {

    private final IService networkElementsService;

    public NetworkElementsController(IService networkElementsService){
        this.networkElementsService = networkElementsService;
    }

    @GetMapping("/")
    public String retrieveNetworkElements(Model model) {
        model.addAttribute("networkElements",  new ReactiveDataDriverContextVariable(networkElementsService.getAllNetworkElements(), 10));
        return "network-elements";
    }

    @GetMapping("/{id}")
    public String deleteNetworkElement(Model model, @PathVariable("id") String id ) {
        networkElementsService.deleteNetworkElement(id);
        return "redirect:/network-elements/";
    }




}
