package com.example.rice.webfluxDemo.controller;

import com.example.rice.webfluxDemo.model.Boss;
import com.example.rice.webfluxDemo.service.BossService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bosses")
public class BossController {

    private final BossService service;

    public BossController(BossService  service) {
        this.service = service;
    }

    @PostMapping
    public Mono<ResponseEntity<Boss>> create(@RequestBody Boss boss) {
        return this.service.save(boss).map(ResponseEntity::ok);
    }

    @PutMapping
    public Mono<ResponseEntity<Boss>> update(@RequestBody Boss boss) {
        if (boss.getId() == null)
        {
            return create(boss);
        }
        return service.save(boss).map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Boss>> findById(@PathVariable String id)
    {
        return service.findOne(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(404).body(null));
    }

    @GetMapping
    public Flux<ResponseEntity<Boss>> list() {
        return service.findAll().map(ResponseEntity :: ok);
    }

}
