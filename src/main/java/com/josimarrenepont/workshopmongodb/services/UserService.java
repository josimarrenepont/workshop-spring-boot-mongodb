package com.josimarrenepont.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josimarrenepont.workshopmongodb.domain.User;
import com.josimarrenepont.workshopmongodb.dto.UserDTO;
import com.josimarrenepont.workshopmongodb.repository.UserRepository;
import com.josimarrenepont.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Not found object"));
	}
	public User insert(User obj) {
		return repository.save(obj);
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());		
	}
}
