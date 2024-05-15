package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class User {
	@Id
	private int id;
	@Column(nullable = false)
	private String name;
	
	private int age;
	
	@Column(unique = true)  
	private long mobile;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Note> notesList;

}
