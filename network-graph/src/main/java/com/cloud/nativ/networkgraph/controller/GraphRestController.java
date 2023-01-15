package com.cloud.nativ.networkgraph.controller;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.service.GraphService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:21 p.m.
 */
@RestController
@RequestMapping(value = "/v1/graphs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost")
public class GraphRestController {

    private final GraphService graphService;

    public GraphRestController(GraphService graphService){
        this.graphService = graphService;
    }

    /**
     * Return a graph of nodes in a specific area (example : area 0 or the backbone)
     *
     * @param area
     *
     * @return graph
     */
    @RequestMapping("/{area}")
    public Graph buildGraph(@PathVariable int area){
        return graphService.buildGraph(area);
    }
}
