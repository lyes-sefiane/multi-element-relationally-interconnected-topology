package com.cloud.nativ.networkgraph.service.graph;

import com.cloud.nativ.networkgraph.domain.Graph;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-15 10:38 a.m.
 */
public interface IGraphService {
    Graph findByArea(int area);
}
