package com.MovFlix.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	int id;
	
	String name;
	long collection;
	
	public Movie() {
		super();
	}

	public Movie(int id, String name, long collection) {
		super();
		this.id = id;
		this.name = name;
		this.collection = collection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCollection() {
		return collection;
	}

	public void setCollection(long collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", collection=" + collection + "]";
	}
	
	
	
}
