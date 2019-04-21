package com.example.rice.webfluxDemo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.example.rice.webfluxDemo.model.Boss;

/**
 * Spring Data MongoDB reactive repository for the Article entity.
 * @author dassiorleando
 */
@Repository
public interface BossRepository extends ReactiveMongoRepository<Boss, String> {

}