package com.cloud.nativ.networkgraph.controller;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.service.graph.IGraphService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-28 12:43 p.m.
 */
@Controller
public class NetworkGraphController {

    private final IGraphService graphService;

    public NetworkGraphController(IGraphService graphService){
        this.graphService = graphService;
    }

    @QueryMapping
    public Graph retrieveGraphBy(@Argument Integer area){
        return graphService.buildByArea(area);
    }

    @QueryMapping
    public Graph retrieveGraph(){
        return graphService.buildAll();
    }

}
