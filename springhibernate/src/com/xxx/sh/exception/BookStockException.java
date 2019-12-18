package com.xxx.sh.exception;
/**
 * 
 * <p>Title: BookStockException</p>  
 * <p>Description: 自定义异常(库存异常)</p>  
 * @author  wpf  
 * @date  2019年12月3日
 */
public class BookStockException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookStockException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BookStockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BookStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BookStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
