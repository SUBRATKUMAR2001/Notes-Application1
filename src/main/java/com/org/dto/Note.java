package com.org.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

public class Note {
	@Id
	private int id;
	
	private String title;
	
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private User user;

}
