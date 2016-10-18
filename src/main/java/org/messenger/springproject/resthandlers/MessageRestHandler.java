package org.messenger.springproject.resthandlers;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.messenger.springproject.dao.mock.MessageServiceMock;
import org.messenger.springproject.dao.mock.ProfileServiceMock;
import org.messenger.springproject.domain.Message;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbException;
import org.messenger.springproject.services.MessageService;
import org.messenger.springproject.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

////message resource is a sub resource of profile resource
@Path("/")

@Produces("application/xml, application/json")
@Consumes("application/xml,application/json")

public class MessageRestHandler {
	@Qualifier("messageservice")
	@Autowired
	private MessageService messageservice;
	@Autowired
	private ProfileService profileservice;

	
	// getting id for profile name in every method because implemented profileservice methods with primary key as 
	// profile name and implemented message service methods with profilid as foreign key .. but made both profileName
	// and profile id as primary keys in profile table in data base
	
	@GET
	public List<Message> getAllMessagesInProfile(@PathParam("profileName") String profileName){
		
		long id = profileservice.getProfileIdWithProfileName(profileName);
		return messageservice.getAllMessagesInProfile(id);
		
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("profileName") String profileName,@PathParam("messageId") long messageId){
		//return commentservice.getComment(messageid,commentid);
		long profileId = profileservice.getProfileIdWithProfileName(profileName);
		return messageservice.getMessage(profileId, messageId);
	}
	
	// need to configure sqlexception mapper
	// message should consists of message id profile id message and author fields
	@POST
	public void addMessage(@PathParam("profileName") String profileName,Message message) throws MessageAlreadyExistInDbException{
	  // return commentservice.addComment(messageid, comment);	
		messageservice.addMessage(message);
	}
	
	// put body contains message
	@PUT
	@Path("/{messageId}")
	public void updateMessage(@PathParam("profileName")String profileName,@PathParam("messageId")long id,Message message){
		messageservice.updateMessage(message);
		
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("profileName") String profileName,@PathParam("messageId") long messageId){
		//commentservice.removeComment(id, commentid);
		long profileId = profileservice.getProfileIdWithProfileName(profileName);
		messageservice.removeMessage(profileId, messageId);
		
	}
	
	

	
}












	
	
	