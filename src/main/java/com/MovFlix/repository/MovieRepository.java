package com.MovFlix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MovFlix.Model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	public Movie findByid(int id);
	
	public List<Movie> findByname(String name);
	
	@Query("SELECT m from Movie m WHERE m.collection BETWEEN :start AND :end")
	public List<Movie> findByCollection(@Param("start") long start, @Param("end") long end);
	
}
