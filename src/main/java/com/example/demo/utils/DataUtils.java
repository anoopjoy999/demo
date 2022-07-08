package com.example.demo.utils;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.example.demo.config.ExceptionMsgs;
import com.example.demo.config.NaceConstants;
import com.example.demo.exceptions.ExceptionResponse;

import java.util.Map;

public class DataUtils {
	
	/**
	 * Returns true if the given String is null or the empty string.
	 * 
	 * @param s    String to test
	 * @param trim true to trim before checking if empty
	 * @return boolean
	 */
	public static boolean isEmpty(String s, boolean trim) {
		if (s == null)
			return true;
		if (trim)
			s = s.trim();
		return "".equals(s);
	}

	/**
	 * Returns true if the given list is null or size is zero.
	 * 
	 * @param list List
	 * @return boolean
	 */
	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * Returns true if the given set is null or size is zero.
	 * 
	 * @param list List
	 * @return boolean
	 */
	public static boolean isEmpty(Set<?> set) {
		return set == null || set.isEmpty();
	}

	/**
	 * Returns true if the given object array is null or length is zero.
	 * 
	 * @param array Object[]
	 * @return boolean
	 */
	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Returns true if the given array is null or length is zero.
	 * 
	 * @param array Object[]
	 * @return boolean
	 */
	public static boolean isEmpty(int[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Returns true if the given array is null or length is zero.
	 * 
	 * @param array Object[]
	 * @return boolean
	 */
	public static boolean isEmpty(byte[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Returns true if the given map is null or size is zero.
	 * 
	 * @param map Map
	 * @return boolean
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return map == null || map.size() == 0;
	}

	/**
	 * Returns true if the given String is null or the empty string.
	 * 
	 * @param s String to test
	 * @return boolean
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}
	public static void setExceptionResponses(ExceptionMsgs msg,ExceptionResponse exceptionResponse) {
		exceptionResponse.setError(msg.getError());
		exceptionResponse.setErrorMessage(msg.getErrorDesc());
		exceptionResponse.setExceptionFound(NaceConstants.EXC_TRUE);
		exceptionResponse.getExceptionList().add(msg.getErrorCode());
		exceptionResponse.setSeverityFlag(NaceConstants.EXCEPTION_NORMAL);
	}
	


public static void setExceptionTrace(Exception e,ExceptionResponse exceptionResponse) {
	Log4jManager.writeErrorLog("[IFSS] [CRITICALITY] ["+exceptionResponse.getSeverityFlag()+"]");
	exceptionResponse.setExceptionDesc("Cause==="+e.getCause()+"Message==="+e.getMessage()+"Formated trase===="+ExceptionUtils.getStackTrace(e));
	Log4jManager.writeErrorLog(exceptionResponse.getExceptionDesc());
}

}
