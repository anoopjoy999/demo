package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.NaceOrder;
import com.example.demo.exceptions.NaceException;
import com.example.demo.model.NaceOrderDto;

public interface NaceService {
	
	
	public NaceOrder putNaceDetails(@RequestBody NaceOrderDto user) throws NaceException;
	public NaceOrderDto getNaceDetails(@RequestParam String order) throws NaceException;

}
