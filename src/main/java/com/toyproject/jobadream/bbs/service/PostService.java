package com.toyproject.jobadream.bbs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.toyproject.jobadream.bbs.dto.PostDto;
import com.toyproject.jobadream.bbs.entity.PostEntity;
import com.toyproject.jobadream.bbs.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<PostDto> getAllPosts() {
		List<PostEntity> posts = postRepository.findAll();
		return posts.stream()
			.map(post -> {
				PostDto postDto = new PostDto();
				postDto.setId(post.getId());
				postDto.setTitle(post.getTitle());
				return postDto;
			})
			.collect(Collectors.toList());
	}

	public PostDto getPostById(Integer postId) {
		PostEntity post = postRepository.findById(postId)
			.orElseThrow(() -> new RuntimeException("Corporation not found with id: " + postId));

		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setContent(post.getContent());
		postDto.setPostingDate(post.getPostingDate());

		return postDto;
	}

}
