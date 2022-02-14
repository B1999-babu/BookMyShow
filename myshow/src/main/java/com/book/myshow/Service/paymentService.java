package com.book.myshow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.myshow.Entity.paymentEntity;
import com.book.myshow.Repository.paymentRepo;

@Service
public class paymentService {

	@Autowired
	private paymentRepo repo;
	
	public void addpayment(paymentEntity p) {
		repo.save(p);
	}
}
