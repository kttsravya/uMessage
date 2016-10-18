package org.messenger.springproject.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.messenger.springproject.dao.jdbc.MessageDaoImplementation;
import org.messenger.springproject.dao.jdbc.ProfileDaoImplementation;
import org.messenger.springproject.domain.Message;
import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDaoTest {
	@Autowired
	@Qualifier("messagedao")
	private MessageDaoImplementation message; 
	private Message m;
	
	@Before
	public void init(){
		// this message already exist in database
		m = new Message(2,1,"hello","vinni");
	}
	@Test
	public void TestGetMessage(){
		long profileId = m.getProfileId();
		long messageId = m.getMessageId();
		Message mes = message.getMessage(profileId, messageId);
		assertEquals(mes,m);
		
	}
	
	@Test
	public void TestAddMessage() throws MessageAlreadyExistInDbException{
		Message me = new Message(1,1,"hi","srav");
		message.addMessage(me);
		Message me1 = message.getMessage(1, 1);
		assertEquals(me, me1);
	}
	@Test(expected = MessageAlreadyExistInDbException.class)
	public void TestDuplicateEntryException() throws MessageAlreadyExistInDbException{
		message.addMessage(m);
	}
	@Test
	public void TestUpdateMessage(){
		m.setMessage("hello srav");
		message.updateMessage(m);
		Message m1 = message.getMessage(m.getProfileId(), m.getMessageId());
		assertEquals(m1.getMessage(), "hello srav");
	}
	@Test
	public void TestRemoveMessage(){
	  ArrayList<Message> messlist = message.getAllMessages();
	  int count = messlist.size();
	  message.removeMessage(1, 1);
	  ArrayList<Message> messlist1 = message.getAllMessages();
	  int count1 = messlist1.size();
	  assertEquals(count-1, count1);
	  
	  
	}
	@Test
	public void TestGetMessagesInGivenProfileId(){
		int profileId = 2;
		ArrayList<Message> messlist = message.getAllMessagesInProfile(profileId);
		for(Message me: messlist){
			System.out.println(me.getMessage());
		}
	}
	
	
	
}
