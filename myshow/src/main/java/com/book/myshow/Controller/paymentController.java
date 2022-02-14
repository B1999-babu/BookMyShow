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

import com.book.myshow.Entity.BookEntity;
import com.book.myshow.Entity.Movie;
import com.book.myshow.Entity.paymentEntity;
import com.book.myshow.Service.BookService;
import com.book.myshow.Service.paymentService;

@Controller
public class paymentController {

	@Autowired
	private paymentService service;

	@Autowired
	private BookService bookservice;

	

	@GetMapping("/payment/{id}")
	public String displaypaymentform(@PathVariable int id, BookEntity bookEntity, Model model) {

		BookEntity bookentity = bookservice.getbookid(id);
		model.addAttribute("book1", bookentity);
		

		return "payment";
	}

	@PostMapping("/insertpayment")
	public String paymentadd(@ModelAttribute paymentEntity p, Movie movie, BookEntity bookEntity, HttpSession session) {
		System.out.println(p);
		service.addpayment(p);
		session.setAttribute("msg", "Your Payment is successfull...");

		return "redirect:/";
	}

	@GetMapping("/bookviewpayment")
	public String bookpayment(Model m2) {
		List<BookEntity> book = bookservice.getallbook();
		m2.addAttribute("book1", book);
		return "bookviewpayment";
	}
}
