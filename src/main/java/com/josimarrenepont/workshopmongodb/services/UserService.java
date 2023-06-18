package com.josimarrenepont.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josimarrenepont.workshopmongodb.domain.User;
import com.josimarrenepont.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll(); 
	}

}
