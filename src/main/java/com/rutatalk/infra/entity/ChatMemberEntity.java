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
@Table(name = "chat_member")
public class ChatMemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "chatRoomId", nullable = false)
	private Long chatRoomId;
	
	@Column(name = "userId", nullable = false)
	private Long userId;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;
	
}
