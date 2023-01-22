package com.cloud.nativ.networkui.controller;

import com.cloud.nativ.networkui.domain.NetworkElement;
import com.cloud.nativ.networkui.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import javax.validation.Valid;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-19 2:11 p.m.
 */
@Controller
@RequestMapping("/network-elements")
public class NetworkElementsController {

    private static Logger logger = LoggerFactory.getLogger(NetworkElementsController.class);

    private final IService networkElementsService;

    public NetworkElementsController(IService networkElementsService){
        this.networkElementsService = networkElementsService;
    }

    @GetMapping("/")
    public String retrieveNetworkElements(Model model) {
        model.addAttribute("networkElements",  new ReactiveDataDriverContextVariable(networkElementsService.retrieveAllNetworkElements(), 10));
        return "network-elements";
    }

    @PostMapping("/{id}")
    public String updateNetworkElement(Model model, @PathVariable("id") String id, @Valid @ModelAttribute NetworkElement networkElement, BindingResult bindingResult) {
        logger.info("Payload : {}", networkElement);
        if (bindingResult.hasErrors()) {
            model.addAttribute("networkElement", networkElement);
            return "edit-network-element";
        }
        networkElementsService.updateNetworkElement(networkElement, id);
        return "redirect:/network-elements/";
    }

    @GetMapping("/edit/{id}")
    public String editNetworkElement(Model model, @PathVariable("id") String id ) {
        model.addAttribute("networkElement", networkElementsService.retrieveNetworkElement(id));
        return "edit-network-element";
    }

    @GetMapping("/delete/{id}")
    public String deleteNetworkElement(Model model, @PathVariable("id") String id ) {
        networkElementsService.deleteNetworkElement(id);
        return "redirect:/network-elements/";
    }
}
