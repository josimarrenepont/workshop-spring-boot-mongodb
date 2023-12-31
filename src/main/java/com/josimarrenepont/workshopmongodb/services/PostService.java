package com.josimarrenepont.workshopmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josimarrenepont.workshopmongodb.domain.Post;
import com.josimarrenepont.workshopmongodb.repository.PostRepository;
import com.josimarrenepont.workshopmongodb.services.exception.ObjectNotFoundException;

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
    
    public List<Post> findBySearch(String text){
    	return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
    	maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
    	return repository.fullSearch(text, minDate, maxDate);
    }


}
