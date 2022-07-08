package com.example.demo.config;

public enum ExceptionMsgs {
	
	GENERAL_EXCEPTION("Application error","EXE_00","Application error, please contact support team"),
	DATABASE_EXCEPTION("Database error","EXE_04","Error occured while processing database output"),
	DATABASE_UPDATION_EXCEPTION("DataBase updation error","EXE_05","Error occured while inserting data into database"),
	UPDATION_EXCEPTION("Updation error","EXE_06","Error occured while updating the details.");
	
	private String error;
	private String errorCode;
	private String errorDesc;
	
	ExceptionMsgs(String error,String errorCode,String errorDesc) {
		this.error = error;
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public String getError() {
		return error;
	}

}
