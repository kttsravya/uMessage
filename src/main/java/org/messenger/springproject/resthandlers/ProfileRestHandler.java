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


import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;
import org.messenger.springproject.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;


@Path("/profiles")

@Produces("application/xml, application/json")
@Consumes("application/xml,application/json")

public class ProfileRestHandler {
	
	@Autowired
	private ProfileService profileService;
//	@Autowired
	//@Qualifier("profileservicemock")
//	ProfileServiceMock profileService = new ProfileServiceMock();
	

	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}

	// need to add exception Mapper for this method
	@POST
	public void  addProfile(Profile profile) throws ProfileAlreadyExistInDbException {
		profileService.addProfile(profile);
		

	}

	@PUT
	@Path("/{profilename}")
	public void updateProfile(@PathParam("profilename") String proname, Profile profile) {
		
		profileService.updateProfile(profile);
		

	}

	@GET
	@Path("/{profilename}")
	public Profile getProfile(@PathParam("profilename") String proname) {
		return profileService.getProfile(proname);
		
		
	}

	@DELETE
	@Path("/{profilename}")
	public void deleteProfile(@PathParam("profilename") String proname) {

		profileService.removeProfile(proname);

	}
	
	@Path("/{profileName}/messages")
	public MessageRestHandler getString(){
		return new MessageRestHandler();
	}

}
