package org.messenger.springproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.messenger.springproject.domain.Message;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageRowMapper implements RowMapper<Message> {

	public Message mapRow(ResultSet arg0, int arg1) throws SQLException {
		long profileId;
		long messageId;
		String message;
		Date created;
		String author;
		Message mess = null;

		messageId = arg0.getLong("messageId");
		profileId = arg0.getLong("profileId");
		message = arg0.getString("message");
		author = arg0.getString("author");

		mess = new Message(profileId, messageId, message, author);

		// created = arg0.getDate("created");

		// profile.setCreated(created);

		return mess;
	}

}
