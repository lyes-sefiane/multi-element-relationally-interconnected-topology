package com.cloud.nativ.networkgraph.controller;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.service.GraphService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:21 p.m.
 */
@RestController
@RequestMapping("/v1/graph")
public class GraphRestController {

    private final GraphService graphService;

    public GraphRestController(GraphService graphService){
        this.graphService = graphService;
    }

    @RequestMapping("/")
    public Graph buildGraph(){
        return graphService.buildGraph();
    }
}
