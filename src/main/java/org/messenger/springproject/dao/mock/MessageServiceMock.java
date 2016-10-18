package org.messenger.springproject.dao.mock;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.messenger.springproject.dao.MessageDaoInterface;
import org.messenger.springproject.domain.Message;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbException;
import org.springframework.stereotype.Component;
@Component("messageservicemock")
public class MessageServiceMock implements MessageDaoInterface {
	
	private ArrayList<Message> mlist;
	
	public MessageServiceMock(){
		Message m;
		mlist = new ArrayList<Message>();
		m = new Message(1,1,"hi","srav");
		mlist.add(m);
		m = new Message(2,1,"hello","vinni");
		mlist.add(m);
	}
	
//	@PostConstruct
//	public void init(){
//		Message m;
//		m = new Message(1,1,"hi","srav");
//		mlist.add(m);
//		m = new Message(2,1,"hello","vinni");
//		mlist.add(m);
//	}

	@Override
	public ArrayList<Message> getAllMessages() {
		
		return mlist;
	}

	@Override
	public ArrayList<Message> getAllMessagesInProfile(long profileId) {
		ArrayList<Message> promes = new ArrayList<Message>();
		for(Message m : mlist){
			if(m.getProfileId()==profileId){
				promes.add(m);
			}
		}
		return promes;
	}

	@Override
	public Message getMessage(long profileId, long messageId) {
		for(Message m : mlist){
			if(m.getProfileId()==profileId && m.getMessageId()==messageId) {
				return m;
			}
		}
		return null;
	}

	@Override
	public void addMessage(Message message1) throws MessageAlreadyExistInDbException {
		//throw new MessageAlreadyExistInDbException("from mock");
		mlist.add(message1);
		
	}

	@Override
	public void updateMessage(Message msg) {
	 long profileId = msg.getProfileId();
	 long messageId = msg.getMessageId();
	 for(Message m : mlist){
			if(m.getProfileId()==profileId && m.getMessageId()==messageId) {
				mlist.remove(m);
			}
		}
	 mlist.add(msg);
		
	}

	@Override
	public void removeMessage(long profileId, long messageId) {
		 for(Message m : mlist){
				if(m.getProfileId()==profileId && m.getMessageId()==messageId) {
					mlist.remove(m);
				}
			}
		
	}

}
