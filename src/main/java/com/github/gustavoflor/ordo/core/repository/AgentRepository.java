package com.github.gustavoflor.ordo.core.repository;

import com.github.gustavoflor.ordo.core.entity.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends MongoRepository<Agent, String> {
}
