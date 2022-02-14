package com.book.myshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.myshow.Entity.Movie;

@Repository
public interface movieRepo extends JpaRepository<Movie, Integer>{

	@Query (value = "select m from Movie m where m.mallname =:theatreName and m.name=:movieName")
	public Movie getMovieByTheatreName(@Param("theatreName") String theatreName, @Param("movieName") String movieName);

	

		
	@Transactional
	@Modifying
	@Query(value ="update Movie m set m.remainingTickets=:remainingTickets where m.id=:movieId")
	public void updateRemainingTickets(@Param("movieId")int movieId, @Param("remainingTickets") int remainingTickets);
	
}
