package org.messenger.springproject.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.messenger.springproject.domain.ErrorMessage;

@Provider
public class MessageAlreadyExistInDbExceptionMapper implements ExceptionMapper<MessageAlreadyExistInDbException>{

	@Override
	public Response toResponse(MessageAlreadyExistInDbException arg0) {
		ErrorMessage err = new ErrorMessage();
		err.setExceptionmessage("this message already exist in profile in data base so it is forbidden to insert again");
		err.setExceptioncode(403);
		
		return Response.status(Status.FORBIDDEN).entity(err).build();
	}

}
