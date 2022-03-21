package com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user", catalog="dbspring")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) @Getter @Setter
private Integer id;
	
	@Column @Getter @Setter
	private String name;
	
	@Column @Getter @Setter
	private String email;
	
	@Column @Getter @Setter
	private String password;
}
