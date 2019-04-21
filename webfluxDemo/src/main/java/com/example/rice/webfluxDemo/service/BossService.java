package com.example.rice.webfluxDemo.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.rice.webfluxDemo.model.Boss;
import com.example.rice.webfluxDemo.repository.BossRepository;

@Service
public class BossService {
    private final BossRepository repository;

    BossService(BossRepository repository) {
        this.repository = repository;
    }

    public Mono<Boss> save(Boss boss) {
        return this.repository.save(boss);
    }

    public Mono<Boss> findOne(String id) {
        return this.repository.findById(id);
    }

    public Flux<Boss> findAll() {
        return this.repository.findAll();
    }

    public Mono<Void> delete(String id) {
        return this.repository.deleteById(id);
    }

}
