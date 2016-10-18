package org.messenger.springproject.services;

import java.util.ArrayList;

import org.messenger.springproject.dao.MessageDaoInterface;

import org.messenger.springproject.domain.Message;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("messageservice")
public class MessageService {
	@Autowired
	@Qualifier("messagedao")
	MessageDaoInterface messageImpl;

	public MessageService() {

	}

	public ArrayList<Message> getAllMessages() {
		ArrayList<Message> allmessages = messageImpl.getAllMessages();
		return allmessages;
	}

	public Message getMessage(long profileId, long messageId) {
		Message mess = messageImpl.getMessage(profileId, messageId);
		return mess;
	}

	public ArrayList<Message> getAllMessagesInProfile(long profileId) {
		ArrayList<Message> mess = messageImpl.getAllMessagesInProfile(profileId);
		return mess;
	}
	
	

	public void addMessage(Message message) throws MessageAlreadyExistInDbException {
		messageImpl.addMessage(message);
	}

	public void updateMessage(Message message) {
		messageImpl.updateMessage(message);
	}

	public void removeMessage(long profileId, long messageId) {
		messageImpl.removeMessage(profileId, messageId);
	}

}