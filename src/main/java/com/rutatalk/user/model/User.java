package com.rutatalk.user.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private int id;
	private String loginId;
	private String password;
	private String nickname;
	private String profileUrl;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	
}
