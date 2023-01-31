package com.cloud.nativ.networkui.controller;

import com.cloud.nativ.networkui.service.IGraphsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-28 9:43 p.m.
 */
@Controller
@RequestMapping("/network-graphs")
public class NetworkGraphController {

    private final IGraphsService graphsService;

    public NetworkGraphController(IGraphsService graphsService){
        this.graphsService = graphsService;
    }

    @GetMapping("/")
    public String retrieveGraph(Model model){
        model.addAttribute("graphs", new ReactiveDataDriverContextVariable(graphsService.retrieveGraph().flux(), 1));
        return "network-graphs";
    }

}
