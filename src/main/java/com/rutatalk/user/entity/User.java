package com.rutatalk.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name="user")
public class User {
	@Id
	private Long id;

	@Column(name = "loginId", nullable = false)
	private String loginId;
	
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "nickname", nullable = false)
	private String nickname;

	@Column(name = "profileUrl")
	private String profileUrl;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp
	private Date updatedAt;
	
}
