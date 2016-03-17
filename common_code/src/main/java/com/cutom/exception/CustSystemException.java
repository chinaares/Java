package com.cutom.exception;

/**
 * @author iRESlab
 *
 */
public class CustSystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;

	public CustSystemException(){
		
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public CustSystemException(ErrorCode errorCode) {
		super(errorCode.getReasonPhrase());
		this.errorCode = errorCode;
	}

	public CustSystemException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public CustSystemException(Throwable cause, ErrorCode errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
}
