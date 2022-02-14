package com.book.myshow.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.book.myshow.Entity.Movie;
import com.book.myshow.Service.movieService;

@Controller
public class CustController {
	
	@Autowired
	private movieService service;

	@GetMapping("/")
	public String home(Model m) {
       List<Movie> movie=service.getAllMovie();
		m.addAttribute("movie", movie);
		return "/index";
	}
	
	@GetMapping("/moviedetails")
	public String moviedetails(Model m1) {
		List<Movie> movie=service.getAllMovie();
		m1.addAttribute("movie1",movie);
		return "moviedetails";
	}
	
	@GetMapping("/addmovie")
	public String addmovie() {
		return "addmovie";
	}
	
	
	@PostMapping("/register")
	public String MovieRegister(@ModelAttribute Movie m,HttpSession session) {
		System.out.println(m);
		service.addMovie(m);
		session.setAttribute("msg", "Movie Details added successfully...");
		return "redirect:/moviedetails";
	}
	
	@GetMapping("/editmovie/{id}")
	public String editmovie(@PathVariable int id,Model m) {
		Movie mv=service.getmovieId(id);
		m.addAttribute("movie",mv);
		return "editmovie";
	}
	
	@PostMapping("/update")
	public String updateMovie(@ModelAttribute Movie m,HttpSession session) {
			service.addMovie(m);
			session.setAttribute("msg","Movie data updated successfully...");
			return "redirect:/moviedetails";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMovie(@PathVariable int id, HttpSession session) {
		service.deleteMovie(id);
		session.setAttribute("msg","Movie data deleted successfully...");
		return "redirect:/moviedetails";
	}
	
	@GetMapping("/{id}")
	public String getMovie(@PathVariable int id, HttpSession session) {
		service.getmovieId(id);
		session.setAttribute("msg","Movie data deleted successfully...");
		return "redirect:/moviedetails";
	}
	
	
}
