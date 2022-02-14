package com.book.myshow.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.myshow.Entity.BookEntity;
import com.book.myshow.Repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo repo;
	
	public void addbook(BookEntity b) {
	
			repo.save(b);
		
	}
	
	public List<BookEntity> getallbook() {
		return repo.findAll();
	}
	
	public BookEntity getbookid(int id) {
		Optional<BookEntity> b=repo.findById(id);
		if(b.isPresent()) {
			return b.get();
		}
		return null;
	}
	
	
	public void deletebyId(int id) {
		repo.deleteById(id);
	}
	
	public int calculate(int price, int tickets) {
	
		return price * tickets;
	}

	public int getNumberOfBookedTickets(String bookDate, String showTime, String theatreName, String movieName) {
		 return repo.getNumberOfBookedTickets(bookDate, showTime, theatreName, movieName);
	}
	
	  
	 

	public BookEntity findBookId(int bookEntity) {
		Optional<BookEntity> b=repo.findById(bookEntity);
		if(b.isPresent()) {
			return b.get();
		}
		
		return null;
	}
	
	
	  public BookEntity findBookTickets(int tickets) { 
		 return   repo.findBookByTickets(tickets);
	 }
	 
	
	
}

