package com.cloud.nativ.networkgraph.repository;

import com.cloud.nativ.networkgraph.domain.entities.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2023-01-10 1:37 p.m.
 */
@Repository
public interface INodeRepository extends MongoRepository<Node, String> {

    @Query(value = "{ipAddress : ?0}")
    Optional<Node> findBy(String ipAddress);

    @Query(value = "{area : ?0}")
    List<Node> findBy(int area);

}
