package com.springboot.rest.example.springbootrestservice.repository;

import com.springboot.rest.example.springbootrestservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {
    User findById(ObjectId id);
}
