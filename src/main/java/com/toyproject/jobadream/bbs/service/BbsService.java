package com.toyproject.jobadream.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toyproject.jobadream.bbs.entity.BbsEntity;
import com.toyproject.jobadream.bbs.repository.BbsRepository;

@Service
public class BbsService {

	// 	@Autowired
	private final BbsRepository bbsRepository;

	// 	// 모든 게시물
	// 	public List<BbsEntity> getAllPosts() {
	// 		return bbsRepository.findAll();
	// 	}

	// 	// ID로 게시물 가져오기 및 조회 수 증가
	// 	public Optional<BbsEntity> getPostById(Long postId) {
	// 		Optional<BbsEntity> post = bbsRepository.findById(postId);
	// 		post.ifPresent(p -> {
	// 			p.setViewCount(p.getViewCount() + 1);
	// 			bbsRepository.save(p);
	// 		});
	// 		return post;
	// 	}
	//
	// 	// 생성
	// 	public BbsEntity createPost(BbsEntity post) {
	// 		return bbsRepository.save(post);
	// 	}

	public BbsService(BbsRepository bbsRepository) {
		this.bbsRepository = bbsRepository;
	}

	public BbsEntity getPostById(Long id) {
		return bbsRepository.findById(id).orElse(null);
	}

	public List<BbsEntity> getAllPosts() {
		return bbsRepository.findAll();
	}
}
