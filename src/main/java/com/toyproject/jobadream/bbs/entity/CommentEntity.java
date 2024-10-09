package com.toyproject.jobadream.bbs.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "comment")
@Entity
@Data
public class CommentEntity {

	@Id
	@Column(name = "id", columnDefinition = "serial4")
	private Integer id;
	@Column(name = "comment", columnDefinition = "TEXT")
	private String comment;
	@Column(name = "commentDate")
	private LocalDateTime commentDate = LocalDateTime.now();
	@Column(name = "post_id")
	private Long postId;

}
