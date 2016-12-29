package com.onlineshop.exception;

public class ProductException extends Exception {
	String message;
	
	public ProductException(String message){
		this.message = message;
	} 
	public String toString(){ 
       return (message) ;
    }
}
