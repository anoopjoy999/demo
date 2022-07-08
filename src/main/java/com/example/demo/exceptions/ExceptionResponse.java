package com.example.demo.exceptions;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.config.NaceConstants;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = NaceConstants.FULL_DATE_TIME2)
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String errorMessage;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getRequestedURI() {
		return requestedURI;
	}
	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}
	public String getExceptionName() {
		return exceptionName;
	}
	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	public String getExceptionDesc() {
		return exceptionDesc;
	}
	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}
	public boolean isExceptionFound() {
		return exceptionFound;
	}
	public void setExceptionFound(boolean exceptionFound) {
		this.exceptionFound = exceptionFound;
	}
	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}
	
	public void setExceptionList(List<String> exceptionList) {
		this.exceptionList = exceptionList;
	}

	public List<String> getExceptionList() {
		return exceptionList;
	}
	
	public String getSeverityFlag() {
		return severityFlag;
	}
	public void setSeverityFlag(String severityFlag) {
		this.severityFlag = severityFlag;
	}
	private String requestedURI;
	private String exceptionName;
	private String exceptionDesc;
	private boolean exceptionFound;
	private List<String> exceptionList = new ArrayList<>();
	private String severityFlag;
}
