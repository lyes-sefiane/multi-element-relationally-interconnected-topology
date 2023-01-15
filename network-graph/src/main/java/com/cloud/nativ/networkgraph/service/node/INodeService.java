package com.cloud.nativ.networkgraph.service.node;

import com.cloud.nativ.networkgraph.domain.entities.Node;

import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-15 10:38 a.m.
 */
public interface INodeService {
    List<Node> findBy(int area);

    Node saveNode(Node node);

    Node updateNode(Node node, String ipAddress);

    void deleteNode(Node node);
}
