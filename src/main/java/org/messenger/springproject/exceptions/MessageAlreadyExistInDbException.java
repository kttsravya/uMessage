package org.messenger.springproject.exceptions;

public class MessageAlreadyExistInDbException extends Exception {
public MessageAlreadyExistInDbException(String message){
	super(message);
}
}
