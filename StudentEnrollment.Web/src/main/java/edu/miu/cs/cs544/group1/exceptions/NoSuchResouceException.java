package edu.miu.cs.cs544.group1.exceptions;

public class NoSuchResouceException extends RuntimeException {
	
	private String message;
	private long resouceId;
	
	public NoSuchResouceException(String message, long resouceId) {
		
		this.message = message;
		this.resouceId = resouceId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getResouceId() {
		return resouceId;
	}
	public void setResouceId(long resouceId) {
		this.resouceId = resouceId;
	}
	
	

}
