package com.book.myshow.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.myshow.Entity.Movie;
import com.book.myshow.Repository.movieRepo;

@Service
public class movieService {

	@Autowired
	private movieRepo repo;
	
	public void addMovie(Movie m) {
		repo.save(m);
	}
	
	public List<Movie> getAllMovie(){
		return repo.findAll();
	}
	
	public Movie getmovieId(int id) {
		Optional<Movie> m=repo.findById(id);
		if(m.isPresent()) {
			return m.get();
		}
		return null;
	}
	
	public void deleteMovie(int id) {
		repo.deleteById(id);
	}

	public Movie getMovieByTheatreName(String theatreName, String movieName) {
		
		return repo.getMovieByTheatreName(theatreName, movieName);
	}
	 
	public void updateRemainingTickets(int movieId, int remainingTickets) {
		repo.updateRemainingTickets(movieId, remainingTickets);
	}
	
}
