package com.MovFlix.controller;

import com.MovFlix.Model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.MovFlix.service.MovieService;

import jakarta.validation.Valid;

@Controller //In @Controller, we can return a view in Spring Web MVC //In @RestController, we can not return a view.
@SessionAttributes("mid")
public class MovieController {
	
	@Autowired
	MovieService serv;
	
	public MovieController(MovieService serv) {
		super();
		this.serv = serv;
	}

	@RequestMapping("MovFlix")
	public String getPage() {
		return "MovFlix";
	}
	
	@RequestMapping(value="getById",method=RequestMethod.GET)
	public String getMoviePage() {
		return "MovieId";
	}
	
	@RequestMapping(value="getById", method=RequestMethod.POST)
	public String getById(ModelMap model,@RequestParam int mid) {
		List<Movie> ls = serv.getById(mid);
		model.addAttribute("movie", ls);
		return "Movie";
	}
	
	@RequestMapping(value="getByName", method=RequestMethod.GET)
	public String getByname() {
		return "MovieName";
	}
	
	@RequestMapping(value="getByCollection", method=RequestMethod.GET)
	public String getByCollection() {
		return "MovieCollection";
	}
	
	@RequestMapping(value="getByCollection", method=RequestMethod.POST)
	public String getByCollection(ModelMap model, @RequestParam long start, @RequestParam long end){
		List<Movie> m = serv.getByCollection(start, end);
		model.addAttribute("movie", m);
		return "Movie"; 
	}
	
	@RequestMapping(value="getByName", method=RequestMethod.POST)
	public String getByNamePage(ModelMap model, String name) {
		List<Movie> ls = serv.getByName(name);
		model.addAttribute("movie", ls);
		return "Movie";
	}
	
	@RequestMapping(value="addmovie", method=RequestMethod.GET)
	public String addMovie() {
		return "AddMovie";
	}
	
	@RequestMapping(value="addmovie", method=RequestMethod.POST)
	public String addmovie(@RequestParam int id,@RequestParam String name, @RequestParam long collection, ModelMap model) {
		model.put("id", id);
		model.put("name", name);
		model.put("collection", collection);
		Movie m = new Movie(id, name, collection);
		serv.addMovie(m);
		List<Movie> ls = serv.allMovies();
		model.addAttribute("movie", ls);
		return "Movie";
	}
	
	@RequestMapping("updatemovie")
	public String updateMovie() {
		return "UpdateMovie";
	}
	
}
