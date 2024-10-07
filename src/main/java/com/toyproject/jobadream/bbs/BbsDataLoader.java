package com.toyproject.jobadream.bbs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.toyproject.jobadream.bbs.entity.BbsEntity;
import com.toyproject.jobadream.bbs.repository.BbsRepository;

@Component
public class BbsDataLoader implements CommandLineRunner {

	private final BbsRepository bbsRepository;

	public BbsDataLoader(BbsRepository bbsRepository) {
		this.bbsRepository = bbsRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// 더미 게시물
		BbsEntity post1 = new BbsEntity();
		post1.setTitle("첫 번째 게시물");
		post1.setContent("첫 번째 게시물의 내용");
		post1.setViewCount(0);
		// bbsRepository.save(post1);

		BbsEntity post2 = new BbsEntity();
		post2.setTitle("두 번째 게시물");
		post2.setContent("두 번째 게시물의 내용");
		post2.setViewCount(0);
		// bbsRepository.save(post2);

		BbsEntity post3 = new BbsEntity();
		post3.setTitle("세 번째 게시물");
		post3.setContent("세 번째 게시물의 내용");
		post3.setViewCount(0);
		// bbsRepository.save(post3);
	}
}
