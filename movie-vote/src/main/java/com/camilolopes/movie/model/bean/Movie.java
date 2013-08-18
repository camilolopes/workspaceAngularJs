package com.camilolopes.movie.model.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Movie implements Serializable{
	
	private static final long serialVersionUID = 2760452572489582540L;
	@Id
	@GeneratedValue
	private long id; 
	private String name; 
	private long totalVote;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTotalVote() {
		return totalVote;
	}
	public void setTotalVote(long totalVote) {
		this.totalVote = totalVote;
	}
	@Override
	public String toString() {
		 
		return name;
	}

}
