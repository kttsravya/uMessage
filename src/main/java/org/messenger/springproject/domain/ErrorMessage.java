package org.messenger.springproject.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
  private String exceptionmessage;
  private int exceptioncode;
public String getExceptionmessage() {
	return exceptionmessage;
}
public void setExceptionmessage(String exceptionmessage) {
	this.exceptionmessage = exceptionmessage;
}
public int getExceptioncode() {
	return exceptioncode;
}
public void setExceptioncode(int exceptioncode) {
	this.exceptioncode = exceptioncode;
}
  
}
