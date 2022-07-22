package com.github.gustavoflor.ordo.repository;

import com.github.gustavoflor.ordo.entity.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends MongoRepository<Agent, String> {
}
