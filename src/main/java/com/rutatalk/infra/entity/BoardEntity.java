package com.rutatalk.infra.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name="board")
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "schduleId", nullable = false)
	private Long schduleId;
	
	@Column(name = "userId", nullable = false)
	private Long userId;
	
	@Column(name = "subject", nullable = false)
	private String subject;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "imageUrl", nullable = false)
	private String imageUrl;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@CreationTimestamp
	private Date updatedAt;
	
}
