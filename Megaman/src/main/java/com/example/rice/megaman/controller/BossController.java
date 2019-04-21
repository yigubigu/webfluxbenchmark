package com.example.rice.megaman.controller;

import com.example.rice.megaman.model.Boss;
import com.example.rice.megaman.repository.BossRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bosses")
public class BossController {
    @Autowired
    private BossRepository repository;

    @RequestMapping( method = RequestMethod.GET)
    public List getAllBosses() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Boss getBossById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyBossById(@PathVariable("id") ObjectId id, @Valid @RequestBody Boss boss) {
        boss.set_id(id);
        repository.save(boss);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Boss createBoss(@Valid @RequestBody Boss boss) {
        boss.set_id(ObjectId.get());
        repository.save(boss);
        return boss;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBoss(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}