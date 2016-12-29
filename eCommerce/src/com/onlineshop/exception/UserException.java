package com.onlineshop.exception;

public class UserException extends Exception {
	String message;
	
	public UserException(String message){
		this.message = message;
	} 
	public String toString(){ 
       return (message) ;
    }
}
