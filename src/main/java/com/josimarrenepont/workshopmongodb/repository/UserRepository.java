package com.josimarrenepont.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.josimarrenepont.workshopmongodb.domain.User;

@Repository	
public interface UserRepository extends MongoRepository<User, String> {


}
