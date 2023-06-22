package com.rutatalk.infra.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name = "schedule")
public class ScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "chatRoomId", nullable = false)
	private Long chatRoomId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "region", nullable = false)
	private String region;

	@Column(name = "startDate", nullable = false)
	private Date startDate;
	
	@Column(name = "endDate", nullable = false)
	private Date endDate;

	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp
	private Date updatedAt;
}
