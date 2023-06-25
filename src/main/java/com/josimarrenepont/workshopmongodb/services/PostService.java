package com.josimarrenepont.workshopmongodb.services;

import com.josimarrenepont.workshopmongodb.domain.Post;
import com.josimarrenepont.workshopmongodb.repository.PostRepository;
import com.josimarrenepont.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;
    
    public Optional<Post> findById(String id){
        Optional<Post> user = repository.findById(id);
        if(user == null){
            throw new ObjectNotFoundException("Object not found!");
        }
        return user;
    }
}
