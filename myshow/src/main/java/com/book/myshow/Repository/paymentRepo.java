package com.book.myshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.myshow.Entity.paymentEntity;

@Repository
public interface paymentRepo extends JpaRepository<paymentEntity, Integer> {

}
