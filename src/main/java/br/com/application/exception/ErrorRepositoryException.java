package br.com.application.exception;

public class ErrorRepositoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorRepositoryException(String error){
		super(error);
	}
}
