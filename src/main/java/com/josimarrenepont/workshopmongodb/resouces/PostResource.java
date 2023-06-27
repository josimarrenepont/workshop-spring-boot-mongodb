package com.josimarrenepont.workshopmongodb.resouces;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josimarrenepont.workshopmongodb.domain.Post;
import com.josimarrenepont.workshopmongodb.resouces.util.URL;
import com.josimarrenepont.workshopmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;


	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Post>> findById(@PathVariable String id) {
		Optional<Post> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> FindByTitle(@RequestParam(value="text", defaultValue= "") String text) {
		text = URL.decodeParam(text); //DECODIFICANDO TEXT
		List<Post> list = service.findBySearch(text);
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue= "") String text,
			@RequestParam(value="minDate", defaultValue= "") String minDate,
			@RequestParam(value="maxDate", defaultValue= "") String maxDate) {
		
		text = URL.decodeParam(text); //DECODIFICANDO TEXT
		Date min = URL.converDate(minDate, new Date(0L));
		Date max = URL.converDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
}
