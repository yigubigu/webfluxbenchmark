package com.example.rice.megaman.repository;

import com.example.rice.megaman.model.Boss;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BossRepository extends MongoRepository<Boss, String> {
    Boss findBy_id(ObjectId _id);
}