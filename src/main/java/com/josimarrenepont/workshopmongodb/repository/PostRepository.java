package com.josimarrenepont.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.josimarrenepont.workshopmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
