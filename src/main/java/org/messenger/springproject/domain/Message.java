package org.messenger.springproject.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {
	long profileId;
	private long messageId;
	private String message;
	private Date created;
	private String author;
	// private Map<Long,Comment> comments = new HashMap<Long, Comment>();

	public Message() {

	}

	public Message(long profileId, long id, String message, String author) {
		this.profileId = profileId;
		this.messageId = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profilId) {
		this.profileId = profilId;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long id) {
		this.messageId = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int Size() {
		return message.length();

	}
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Message)){
			return false;
		}
		Message me = (Message)obj;
		return (me.getProfileId()==this.profileId && me.getMessageId()==this.messageId);
			
	
		
	}
}
