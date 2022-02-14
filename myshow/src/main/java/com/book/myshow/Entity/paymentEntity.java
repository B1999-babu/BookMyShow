package com.book.myshow.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payments")
public class paymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long cardnumber;
	private int amount;
	private String expdate;
	private int cvc;
	private String holdername;
	
	@OneToOne(cascade=CascadeType.ALL)
	private BookEntity bookid;
	
	public paymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getHoldername() {
		return holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	
	
	
	public BookEntity getBookid() {
		return bookid;
	}

	public void setBookid(BookEntity bookid) {
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "paymentEntity [id=" + id + ", cardnumber=" + cardnumber + ", amount=" + amount + ", expdate=" + expdate
				+ ", cvc=" + cvc + ", holdername=" + holdername + "]";
	}
	
	
	
}
