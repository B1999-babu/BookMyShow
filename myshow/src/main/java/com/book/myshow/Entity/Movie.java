package com.book.myshow.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mallname; //Theater name
	private String name;     //movie name
	private String date;     //show date
	private String time1;   //show1
	private String time2;   //show2
	private int noOfTickets;
	private int remainingTickets;
	private int price;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMallname() {
		return mallname;
	}


	public void setMallname(String mallname) {
		this.mallname = mallname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime1() {
		return time1;
	}


	public void setTime1(String time1) {
		this.time1 = time1;
	}


	public String getTime2() {
		return time2;
	}


	public void setTime2(String time2) {
		this.time2 = time2;
	}


	
	
	public int getNoOfTickets() {
		return noOfTickets;
	}


	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}


	public int getRemainingTickets() {
		return remainingTickets;
	}


	public void setRemainingTickets(int remainingTickets) {
		this.remainingTickets = remainingTickets;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", mallname=" + mallname + ", name=" + name + ", date=" + date + ", time1=" + time1
				+ ", time2=" + time2 + ", price=" + price + "]";
	}
	
	
	

}
