package com.example.demo.service;

import com.example.demo.entity.NaceOrder;
import com.example.demo.exceptions.NaceException;
import com.example.demo.model.NaceOrderDto;

public interface NaceService {
	
	
	public NaceOrder putNaceDetails(NaceOrderDto user) throws NaceException;
	public NaceOrderDto getNaceDetails(String order) throws NaceException;

}
