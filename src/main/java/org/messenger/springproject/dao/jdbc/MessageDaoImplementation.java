package org.messenger.springproject.dao.jdbc;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.messenger.springproject.dao.MessageDaoInterface;
import org.messenger.springproject.domain.Message;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("messagedao")
public class MessageDaoImplementation implements MessageDaoInterface {
	@Autowired
	@Qualifier("dataSource1")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MessageRowMapper messageMapper;

	@PostConstruct
	public void setUp() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public MessageDaoImplementation() {

	}

	public ArrayList<Message> getAllMessages() {
		String sql = "select * from messages";
		ArrayList<Message> message = (ArrayList<Message>) jdbcTemplate.query(sql, messageMapper);
		return message;

	}

	public ArrayList<Message> getAllMessagesInProfile(long profileId) {
		String sql = "select * from messages where profileId=?";
		ArrayList<Message> mess = (ArrayList<Message>) jdbcTemplate.query(sql, new Object[] { profileId },
				messageMapper);
		return mess;
	}

	public Message getMessage(long profileId, long messageId) {
		String sql = "select * from messages where profileId=?&&messageId=?";
		Message message = jdbcTemplate.queryForObject(sql, new Object[] { profileId, messageId }, messageMapper);
		return message;
	}

	public void addMessage(Message message1) throws MessageAlreadyExistInDbException {
		long profileId = message1.getProfileId();
		long messageId = message1.getMessageId();
		String message = message1.getMessage();
		String author = message1.getAuthor();
		
		ArrayList<Message> messlist = getAllMessages();
		for(Message m : messlist){
			if(m.getProfileId()==message1.getProfileId() && m.getMessageId()==message1.getMessageId()){
				throw new MessageAlreadyExistInDbException("message already exist in db, duplicate entry");
			}
		}

		String sql = "INSERT INTO messages(profileId,messageId,message,author) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { profileId, messageId, message, author });

	}

	public void updateMessage(Message msg) {
		long profId = msg.getProfileId();
		long messId = msg.getMessageId();

		String sql1 = "DELETE from messages where profileId=?&&messageId=?";
		jdbcTemplate.update(sql1, new Object[] { profId, messId });

		String message = msg.getMessage();
		String author = msg.getAuthor();
		String sql = "INSERT INTO messages(profileId,messageId,message,author) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { profId, messId, message, author });

	}

	public void removeMessage(long profileId, long messageId) {

		String sql1 = "DELETE from messages where profileId=?&&messageId=?";
		jdbcTemplate.update(sql1, new Object[] { profileId, messageId });

	}

	
}
