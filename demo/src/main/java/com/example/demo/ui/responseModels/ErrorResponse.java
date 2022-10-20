package com.example.demo.ui.responseModels;

import java.util.Date;

public class ErrorResponse {
	private Date timestamp;
	private String errorMessage;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
