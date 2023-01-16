package com.cloud.nativ.networkgraph.controller;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.exception.entities.ExceptionResponse;
import com.cloud.nativ.networkgraph.service.graph.IGraphService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 10:21 p.m.
 */
@RestController
@RequestMapping(value = "/v1/graphs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Network Graph Controller")
@PropertySource("${springdoc.api-docs.messages}")
@CrossOrigin(origins = "http://localhost")
@Validated
public class NetworkGraphRestController {

    private final IGraphService graphService;

    public NetworkGraphRestController(IGraphService graphService){
        this.graphService = graphService;
    }

    /**
     * Return a graph of nodes in a specific area (example : area 0 or the backbone)
     *
     * @param area
     *
     * @return graph
     */
    @GetMapping("/{area}")
    @Operation(summary = "${createGraph}")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Graph.class)))
    // Validation Fail.
    @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Graph createGraph(@PathVariable @Valid @Min(value = 0, message = "area min value is 0") Integer area){
        return graphService.findByArea(area);
    }
}
