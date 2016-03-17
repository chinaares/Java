package com.cutom.exception;

public class CustException extends Exception {

	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;

	public CustException() {
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public CustException(ErrorCode errorCode) {
		super(errorCode.getReasonPhrase());
		this.errorCode = errorCode;
	}

	public CustException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public CustException(Throwable cause, ErrorCode errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
}
