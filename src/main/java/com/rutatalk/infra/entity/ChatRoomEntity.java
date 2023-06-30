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
@Getter
@Builder
@Table(name = "chat_room")
@Entity
public class ChatRoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "roomImageUrl", nullable = true)
	private String roomImageUrl;

	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updatedAt")
	@CreationTimestamp
	private Date updatedAt;
	
}
