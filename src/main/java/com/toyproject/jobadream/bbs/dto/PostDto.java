package com.toyproject.jobadream.bbs.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostDto {
	private Integer id;
	private String title;
	private String content;
	private LocalDateTime postingDate;
}
