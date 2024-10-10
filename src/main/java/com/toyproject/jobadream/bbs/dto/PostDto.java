package com.toyproject.jobadream.bbs.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class PostDto {
	private Integer id;
	private String title;
	private String content;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime postingDate;
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<CommentDto> contents;
	private Integer viewCount;
}
