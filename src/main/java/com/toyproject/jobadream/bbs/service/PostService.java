package com.toyproject.jobadream.bbs.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toyproject.jobadream.bbs.dto.CommentDto;
import com.toyproject.jobadream.bbs.dto.PostDto;
import com.toyproject.jobadream.bbs.entity.CommentEntity;
import com.toyproject.jobadream.bbs.entity.PostEntity;
import com.toyproject.jobadream.bbs.repository.CommentRepository;
import com.toyproject.jobadream.bbs.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	public PostService(PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}

	// 모든 포스트 조회 메소드
	public List<PostDto> getAllPosts() {
		List<PostEntity> postEntities = postRepository.findAll();
		List<PostDto> postDtos = new ArrayList<>();

		for (PostEntity post : postEntities) {
			PostDto postDto = convertToPostDto(post);
			postDtos.add(postDto);
		}

		return postDtos;
	}

	// 특정 게시물 조회 메소드
	public PostDto getPostById(Integer postId) {
		PostEntity postEntity = postRepository.findById(postId)
			.orElseThrow(() -> new RuntimeException("Post not found")); // 예외 처리
		return convertToPostDto(postEntity);
	}

	// 게시글 작성 메소드
	public PostDto createPost(PostDto postDto) {
		PostEntity postEntity = new PostEntity();
		postEntity.setTitle(postDto.getTitle());
		postEntity.setContent(postDto.getContent());
		postEntity.setPostingDate(LocalDateTime.now()); // 현재 시간으로 설정
		postEntity.setViewCount(0); // 뷰 카운트 초기화

		PostEntity savedPost = postRepository.save(postEntity);
		return convertToPostDto(savedPost);
	}

	public PostDto updatePost(Integer postId, PostDto postDto) {
		// 해당 ID의 포스트를 찾습니다.
		PostEntity postEntity = postRepository.findById(postId)
			.orElseThrow(() -> new RuntimeException("게시물이 존재하지 않습니다.")); // 예외 처리
		LocalDateTime modifiedDate = LocalDateTime.now();

		// 포스트 수정
		postEntity.setTitle(postDto.getTitle());
		postEntity.setContent(postDto.getContent());
		postEntity.setPostingDate(modifiedDate);

		// 변경 사항을 저장
		PostEntity updatedPost = postRepository.save(postEntity);

		// PostDto 객체 생성 및 수정된 값을 설정
		PostDto responseDto = new PostDto();
		responseDto.setId(updatedPost.getId());
		responseDto.setTitle(updatedPost.getTitle());
		responseDto.setContent(updatedPost.getContent());
		responseDto.setPostingDate(updatedPost.getPostingDate());
		responseDto.setViewCount(updatedPost.getViewCount());

		return responseDto;
	}

	// DTO 변환 메소드
	private PostDto convertToPostDto(PostEntity post) {
		List<CommentEntity> commentEntities = commentRepository.findByPost(post);
		List<CommentDto> commentDtos = convertToCommentDtos(commentEntities);

		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setContent(post.getContent());
		postDto.setPostingDate(post.getPostingDate());
		postDto.setContents(commentDtos);
		postDto.setViewCount(post.getViewCount());

		return postDto;
	}

	// DTO 변환 메소드
	private List<CommentDto> convertToCommentDtos(List<CommentEntity> commentEntities) {
		List<CommentDto> commentDtos = new ArrayList<>();
		for (CommentEntity comment : commentEntities) {
			CommentDto commentDto = new CommentDto();
			commentDto.setId(comment.getId());
			commentDto.setComment(comment.getComment());
			commentDto.setCommentDate(comment.getCommentDate());
			commentDto.setPostId(comment.getPost().getId());
			commentDtos.add(commentDto);
		}
		return commentDtos;
	}

	// 댓글 삭제 메소드
	public String deletePost(Integer postId) {
		PostEntity post = postRepository.findById(postId)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));
		postRepository.delete(post);
		return "게시글이 성공적으로 삭제되었습니다.";
	}

}
