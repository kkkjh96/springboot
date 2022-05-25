package com.JPA_Specification.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JPA_Specification.domain.Post;
import com.JPA_Specification.repository.PostRepository;
import com.JPA_Specification.repository.PostSpecs;
import com.JPA_Specification.repository.PostSpecs.SearchKey;

@Controller
public class PostController {

	private final PostRepository postRepository;
	
	public PostController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@GetMapping("/post/list")
	public List<Post> getPostList(@RequestParam(required = false) Map<String, Object> searchRequest){
		Map<SearchKey, Object> searchKeys = new HashMap<>();
		for(String key : searchRequest.keySet()) {
			searchKeys.put(SearchKey.valueOf(key.toUpperCase()), searchRequest.get(key));
		}
		
		return searchKeys.isEmpty()
				? postRepository.findAll()
				: postRepository.findAll(PostSpecs.searchWith(searchKeys));
	}
}
