package org.messenger.springproject.dao;

import java.util.ArrayList;

import org.messenger.springproject.domain.Message;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbException;

public interface MessageDaoInterface {
	public ArrayList<Message> getAllMessages();

	public ArrayList<Message> getAllMessagesInProfile(long profileId);

	public Message getMessage(long profileId, long messageId);

	public void addMessage(Message message1) throws MessageAlreadyExistInDbException;

	public void updateMessage(Message msg);

	public void removeMessage(long profileId, long messageId);
	
	
}
