package com.book.myshow.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String theatrename;
	private String moviename;
	private String bookdate;
	private String showtime;
	private int price;
	private int tickets;
	private int totalprice;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="bookid")
	private paymentEntity paymentEntity;
	
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getTheatrename() {
		return theatrename;
	}


	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}


	public String getMoviename() {
		return moviename;
	}


	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}


	public String getBookdate() {
		return bookdate;
	}


	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}


	public String getShowtime() {
		return showtime;
	}


	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getTickets() {
		return tickets;
	}


	public void setTickets(int tickets) {
		this.tickets = tickets;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	

	public paymentEntity getPaymentEntity() {
		return paymentEntity;
	}


	public void setPaymentEntity(paymentEntity paymentEntity) {
		this.paymentEntity = paymentEntity;
	}


	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", theatrename="
				+ theatrename + ", moviename=" + moviename + ", bookdate=" + bookdate + ", showtime=" + showtime
				+ ", price=" + price + ", tickets=" + tickets + ", totalprice=" + totalprice + "]";
	}
	
	
	
	
	
}
