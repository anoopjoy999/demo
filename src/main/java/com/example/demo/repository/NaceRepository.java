package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NaceOrder;



@Repository
public interface NaceRepository extends JpaRepository<NaceOrder, String> {
	
	@Query("SELECT u FROM NaceOrder u WHERE u.orderId = ?1")
	NaceOrder findByOrder(String order);

}