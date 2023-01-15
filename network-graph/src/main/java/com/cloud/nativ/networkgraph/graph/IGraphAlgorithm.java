package com.cloud.nativ.networkgraph.graph;

import com.cloud.nativ.networkgraph.domain.Graph;
import com.cloud.nativ.networkgraph.domain.entities.Node;

import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-13 10:14 p.m.
 */

@FunctionalInterface
public interface IGraphAlgorithm {

    Graph build(List<Node> nodes);

}
