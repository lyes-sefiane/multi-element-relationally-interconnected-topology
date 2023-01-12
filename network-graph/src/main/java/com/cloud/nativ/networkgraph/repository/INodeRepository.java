package com.cloud.nativ.networkgraph.repository;

import com.cloud.nativ.networkgraph.domain.entities.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 1:37 p.m.
 */
@Repository
public interface INodeRepository extends MongoRepository<Node, String> {

}
