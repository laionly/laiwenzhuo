package com.xxx.tx.exception;
/**
 * 
 * <p>Title: AccountException</p>  
 * <p>Description: 余额不足异常</p>  
 * @author  wpf  
 * @date  2019年12月3日
 */
public class AccountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
