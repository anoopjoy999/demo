package com.example.demo.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.NaceOrder;
import com.example.demo.exceptions.NaceException;
import com.example.demo.model.NaceOrderDto;
import com.example.demo.model.ResponseMessage;
import com.example.demo.service.NaceService;

@ExtendWith(MockitoExtension.class)
public class NaceControllerUnitTests {
	
	
	@Mock
    NaceService naceService;

    @InjectMocks
    private NaceController naceController; 
	
	   @Test
	   public void putNaceDetailsTest(){
		try {
			Mockito.when(naceService.putNaceDetails(Mockito.any())).thenReturn(new NaceOrder());
			ResponseMessage message = naceController.putNaceDetails(new NaceOrderDto());
			//Mockito.verify(naceController.putNaceDetails(new NaceOrderDto()));
			assertNotNull(message);
			}catch(Exception e) {
		}
	   }
	   @Test
	   public void putNaceDetailsTestException(){
		try {
			Mockito.when(naceService.putNaceDetails(Mockito.any())).thenThrow(new RuntimeException());
			naceController.putNaceDetails(new NaceOrderDto());
			}catch(Exception e) {
		}
	   }
	   @Test
	   public void putNaceDetailsTestNaceException(){
		try {
			Mockito.when(naceService.putNaceDetails(Mockito.any())).thenThrow(new NaceException());
			naceController.putNaceDetails(new NaceOrderDto());
			}catch(Exception e) {
		}
	   }
	   
	   @Test
	   public void getNaceDetailsTest(){
		try {
			Mockito.when(naceService.getNaceDetails(Mockito.any())).thenReturn(new NaceOrderDto());
			String order="order";
			NaceOrderDto dto = naceController.getNaceDetails(order);
			assertNotNull(dto);
			}catch(Exception e) {
		}
	   }
	   @Test
	   public void getNaceDetailsTestException(){
		try {
			String order="order";
			Mockito.when(naceService.getNaceDetails(Mockito.any())).thenThrow(new RuntimeException());
			naceController.getNaceDetails(order);
			}catch(Exception e) {
		}
	   }
	   @Test
	   public void getNaceDetailsTestNaceException(){
		try {
			String order="order";
			Mockito.when(naceService.getNaceDetails(Mockito.any())).thenThrow(new NaceException());
			naceController.getNaceDetails(order);
			}catch(Exception e) {
		}
	   }

}
