package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.config.ExceptionMsgs;
import com.example.demo.entity.NaceOrder;
import com.example.demo.exceptions.ExceptionResponse;
import com.example.demo.exceptions.NaceException;
import com.example.demo.model.NaceOrderDto;
import com.example.demo.repository.NaceRepository;
import com.example.demo.utils.DataUtils;
import com.example.demo.utils.Log4jManager;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class NaceServiceImpl implements NaceService{
	
	@Autowired
	private NaceRepository naceRepository;

	@Override
	public NaceOrder putNaceDetails(NaceOrderDto order) throws NaceException {
		try {
			NaceOrder obj = new NaceOrder(order);
			return naceRepository.save(obj);
			
		} 
    	catch(Exception e) {
    		Log4jManager.writeErrorLog("Exception in NaceServiceImpl.putNaceDetails");
    		ExceptionResponse exceptionResponse = new ExceptionResponse();
    		DataUtils.setExceptionResponses(ExceptionMsgs.DATABASE_UPDATION_EXCEPTION,exceptionResponse);
    		DataUtils.setExceptionTrace(e,exceptionResponse);
    		throw new NaceException(exceptionResponse);
    	}
	}

	@Override
	public NaceOrderDto getNaceDetails(String order) throws NaceException {
		try {
			NaceOrder obj= naceRepository.findByOrder(order);
			return new NaceOrderDto(obj);
		} 
    	catch(Exception e) {
    		Log4jManager.writeErrorLog("Exception in NaceServiceImpl.getNaceDetails");
    		ExceptionResponse exceptionResponse = new ExceptionResponse();
    		DataUtils.setExceptionResponses(ExceptionMsgs.DATABASE_EXCEPTION,exceptionResponse);
    		DataUtils.setExceptionTrace(e,exceptionResponse);
    		throw new NaceException(exceptionResponse);
    	}
	}

}
