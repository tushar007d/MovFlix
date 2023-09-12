package com.MovFlix.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovFlix.Model.Movie;
import com.MovFlix.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository repo;
	
	public List<Movie> getById(int id) {
		Movie m = repo.getById(id);
		List<Movie> ls =new ArrayList<Movie>();
		ls.add(m);
		return  ls;
	}
	
	public List<Movie> getByName(String name) {
		name=name.toLowerCase();
		List<Movie> ls = repo.findByname(name);
		return ls;
	}
	
	public List<Movie> getByCollection(long start, long end){
		List<Movie> m = repo.findByCollection(start, end);
		return m;
	}
	
	public Movie addMovie(Movie m) {
		return repo.save(m);
	} 
	 
	public List<Movie> allMovies(){
		List<Movie> m = repo.findAll();
		return m;
	}
	
}
