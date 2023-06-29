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
@Builder
@Table(name = "friends")
public class FriendsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "userId", nullable = false)
	private Long userId;
	
	@Column(name = "followId", nullable = false)
	private Long followId;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;
}
