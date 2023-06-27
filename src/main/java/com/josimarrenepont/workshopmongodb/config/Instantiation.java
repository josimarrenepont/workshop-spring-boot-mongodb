package com.josimarrenepont.workshopmongodb.config;

import com.josimarrenepont.workshopmongodb.domain.Post;
import com.josimarrenepont.workshopmongodb.domain.User;
import com.josimarrenepont.workshopmongodb.dto.AuthorDTO;
import com.josimarrenepont.workshopmongodb.dto.ComentDTO;
import com.josimarrenepont.workshopmongodb.repository.PostRepository;
import com.josimarrenepont.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); 
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
	
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("2023/03/21"),"Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("2023/03/23"),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		ComentDTO coment1 = new ComentDTO("Boa viagem", sdf.parse("21/03/2023"), new AuthorDTO(alex));
		ComentDTO coment2 = new ComentDTO("Bom dia", sdf.parse("23/03/2023"), new AuthorDTO(bob));

		post1.getComents().addAll(Arrays.asList(coment1, coment2));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));

		userRepository.save(maria);
	}
}
