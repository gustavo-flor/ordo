package com.github.gustavoflor.ordo.repository;

import com.github.gustavoflor.ordo.entity.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends MongoRepository<Agent, String> {
    Page<Agent> findAllByUserId(String userId, Pageable pageable);

    Optional<Agent> findByIdAndUserId(String id, String userId);

    void deleteByIdAndUserId(String id, String userId);
}
