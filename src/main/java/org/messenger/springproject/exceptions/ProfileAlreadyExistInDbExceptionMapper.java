package org.messenger.springproject.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.messenger.springproject.domain.ErrorMessage;

// when jax rs encounters ProfileAlreadyExistInDb thrown by profilerestHandler it maps this 
// exception mapper with profileAlreadyExistInDbException and sent this response to client through postman
// i am sending statu.Forbidden so when client try to insert record that already existed in Db the client side
// will see response as forbidden in header where as body as standard  server error to customize body we need to 
// code some extra  stuff
@Provider
public class ProfileAlreadyExistInDbExceptionMapper implements ExceptionMapper<ProfileAlreadyExistInDbException> {

	@Override
	public Response toResponse(ProfileAlreadyExistInDbException arg0) {
		ErrorMessage err = new ErrorMessage();
		err.setExceptionmessage("this profile already exist in data base so it is forbidden to insert again");
		err.setExceptioncode(403);
		
		
		return Response.status(Status.FORBIDDEN).entity(err).build();
	}
	
	

}
