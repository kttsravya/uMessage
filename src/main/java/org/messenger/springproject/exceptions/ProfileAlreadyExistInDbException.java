package org.messenger.springproject.exceptions;

public class ProfileAlreadyExistInDbException extends Exception {
public ProfileAlreadyExistInDbException(String message){
	super(message);
}
}
