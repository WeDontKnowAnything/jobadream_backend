package com.toyproject.jobadream.bbs.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDto {
	private Integer id;
	private String comment;
	private LocalDateTime commentDate;
	private Long postId;
}
