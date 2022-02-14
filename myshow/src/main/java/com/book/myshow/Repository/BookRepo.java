package com.book.myshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.myshow.Entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

	@Query(value = "select b from BookEntity b where b.tickets=:tickets")
	public BookEntity findBookByTickets(@Param("tickets") int tickets);

	@Transactional
	@Query(value = "select sum(b.tickets) from BookEntity b where b.bookdate =:bookDate and b.showtime =:showTime "
			+ "and b.moviename =:movieName and b.theatrename=:theatreName")
	public int getNumberOfBookedTickets(@Param("bookDate") String bookDate, @Param("showTime") String showTime,
			@Param("theatreName") String theatreName, @Param("movieName") String movieName);

}







