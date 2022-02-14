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
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.myshow.Entity.BookEntity;
import com.book.myshow.Entity.Movie;
import com.book.myshow.Service.BookService;
import com.book.myshow.Service.movieService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private movieService movieService;

	@GetMapping("/bookform/{id}")
	public String getbook(@PathVariable int id, Model m1) {
		Movie m = movieService.getmovieId(id);
		m1.addAttribute("movie", m);

		return "bookform";
	}

	@PostMapping("/bookform")
	public String addbook(@ModelAttribute BookEntity bookentity) {

		// bookService.addbook(bookentity);

		// BookEntity bookentity = bookService.getbookid(id);

		Movie movie = movieService.getMovieByTheatreName(bookentity.getTheatrename(), bookentity.getMoviename());
		// *****BookEntity book = bookservice.findBookTickets(bookentity.getTickets());
		int bookedTickets = bookService.getNumberOfBookedTickets(bookentity.getBookdate(), bookentity.getShowtime(),
				bookentity.getTheatrename(), bookentity.getMoviename());
		int remainingTickets = movie.getNoOfTickets() - bookedTickets;
		if (remainingTickets >= bookentity.getTickets()) {
			bookService.addbook(bookentity);

		} else {

			return "badRequestPage";
		}

		return "redirect:/bookviewpayment";
	}

	@GetMapping("bookview")
	public String bookview(Model m1) {
		List<BookEntity> book = bookService.getallbook();
		m1.addAttribute("book1", book);
		return "bookview";
	}

	@GetMapping("/editbook/{id}")
	public String bookedit(@PathVariable int id, Model m2) {
		BookEntity bk = bookService.getbookid(id);
		m2.addAttribute("book1", bk);
		return "editbook";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/deletebook/{id}")
	public String deletebook(@PathVariable int id, HttpSession session) {
		bookService.deletebyId(id);
		session.setAttribute("msg", "Booking ticket cancelled successfully...");
		return "redirect:/bookview";
	}

}
