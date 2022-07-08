package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ExceptionMsgs;
import com.example.demo.config.RequestMappingConfig;
import com.example.demo.exceptions.ExceptionResponse;
import com.example.demo.exceptions.NaceException;
import com.example.demo.model.NaceOrderDto;
import com.example.demo.model.ResponseMessage;
import com.example.demo.service.NaceService;
import com.example.demo.utils.DataUtils;
import com.example.demo.utils.Log4jManager;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class NaceController {
	
	
	@Autowired
	private NaceService naceService;
	
	@PostMapping(RequestMappingConfig.PUT_NACE_DETAILS)
	public ResponseMessage putNaceDetails(@RequestBody NaceOrderDto order) throws NaceException{
		String message = null;
		try {
			naceService.putNaceDetails(order);
			message = "Nace details added successfully: " + order.getOrder();
			return new ResponseMessage(message);
		} catch(NaceException e) {
    		throw e;
    	}
    	catch(Exception e) {
    		Log4jManager.writeErrorLog("Exception in NaceController.putNaceDetails");
    		ExceptionResponse exceptionResponse = new ExceptionResponse();
    		DataUtils.setExceptionResponses(ExceptionMsgs.GENERAL_EXCEPTION,exceptionResponse);
    		DataUtils.setExceptionTrace(e,exceptionResponse);
    		throw new NaceException(exceptionResponse);
    	}
	}
	
	
	@GetMapping(RequestMappingConfig.GET_NACE_DETAILS)
	public NaceOrderDto getNaceDetails(@RequestParam String order) throws NaceException{
		try {
			return naceService.getNaceDetails(order);
			
		} catch(NaceException e) {
    		throw e;
    	}
    	catch(Exception e) {
    		Log4jManager.writeErrorLog("Exception in NaceController.getNaceDetails");
    		ExceptionResponse exceptionResponse = new ExceptionResponse();
    		DataUtils.setExceptionResponses(ExceptionMsgs.GENERAL_EXCEPTION,exceptionResponse);
    		DataUtils.setExceptionTrace(e,exceptionResponse);
    		throw new NaceException(exceptionResponse);
    	}
	}

}
