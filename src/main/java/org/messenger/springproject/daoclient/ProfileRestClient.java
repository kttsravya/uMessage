package org.messenger.springproject.daoclient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.domain.ProfileList;

public class ProfileRestClient {
	static private Logger logger = Logger.getLogger(ProfileRestClient.class);
	private static String PROFILE_SERVICES_URL = "http://localhost:8080/springproject/webservices/profiles/";
	private static Client client = null;

	public static void main(String args[]) {

		//testLookUpProfile();
		//error////testProfilesLookup();
		//testPost();

	}

	/* Client that will not add the authorization header */
	private static Client getClient() {
		if (client == null) {
			client = ClientBuilder.newClient();
		}

		return client;
	}

	public static Profile testLookUpProfile() {
		int responseCode;
		Client client = getClient();
		String profileName = "sravyasravs";
		Profile profile = null;

		// Targeting the RESTful Webservice we want to invoke by capturing it in
		// WebTarget instance.
		WebTarget target = client.target(PROFILE_SERVICES_URL + profileName);

		// Building the request i.e a GET request to the RESTful Webservice
		// defined
		// by the URI in the WebTarget instance.
		Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
		Response response = request.get();

		responseCode = response.getStatus();
		logger.info("The response code is: " + responseCode);

		if (responseCode == 200) {
			// StudentList listOfStudents =
			// response.readEntity(StudentList.class);
			// logger.info("Retrieved student list from Http Get request: " +
			// listOfStudents);

			profile = response.readEntity(Profile.class);

			logger.info(profile);
		}
		return profile;
	}

//	public static void testProfilesLookup() {
//		int responseCode;
//		Client client = getClient();
//
//		// Profile profile=null;
//
//		// Targeting the RESTful Webservice we want to invoke by capturing it in
//		// WebTarget instance.
//		WebTarget target = client.target(PROFILE_SERVICES_URL);
//
//		// Building the request i.e a GET request to the RESTful Webservice
//		// defined
//		// by the URI in the WebTarget instance.
//		Builder request = target.request(MediaType.APPLICATION_JSON_TYPE);
//		Response response = request.get();
//
//		responseCode = response.getStatus();
//		logger.info("The response code is: " + responseCode);
//
//		if (responseCode == 200) {
//			ProfileList listOfProfiles = response.readEntity(ProfileList.class);
//			logger.info("Retrieved profile list from Http Get request: " + listOfProfiles);
//
//			// profile = response.readEntity(Profile.class);
//
//			logger.info(listOfProfiles);
//		}
//
//	}
	
	
	public static Profile createNewProfile() {

		 long id = 25;  
		String profileName="satyasatssss";
		String firstName = "satyaaa";
		String lastName ="satssss";
		Profile prof;

		 prof = new Profile();
		 prof.setId(id);
		 prof.setProfileName(profileName);
		 
		 prof.setFirstName(firstName);
		 prof.setLastName(lastName);
		 return prof;

		 }
	
	 /* Using a POST Http Command, we'll add a completely new student */
	 public static void testPost() {
	 int responseCode;
	 Profile newProfile;
	 Client client = getClient();

	 newProfile = createNewProfile();
	
	 WebTarget target = client.target(PROFILE_SERVICES_URL);
	
	 Builder request = target.request();
	 request.accept(MediaType.APPLICATION_JSON_TYPE);
	 Response response = request.post(Entity.xml(newProfile));
	
	 responseCode = response.getStatus();
	 logger.info("The response code from Post operation is: " + responseCode);
	
	 if (responseCode == 201) {
	 Profile createdProfile = response.readEntity(Profile.class);
	 logger.debug("Student object returned by the POST command: " +createdProfile);
	}

}


 }

// /* Using a PUT Http Command, we'll modify an existing student */
// public static void testPut() {
// int idToModify = 100; /* Just some hardcoded test data */
// int responseCode;
// Student studentToChange;
//
// /* First lookup our Student object. Then we'll make a change. */
//
// Client client = getClient();
//
// studentToChange = testLookupStudent();
// if (studentToChange == null) {
// logger.info("Unable to perform the PUT request. The lookup of student
// returned null. ");
// return;
// }
//
// studentToChange.setAge(32);
//
// WebTarget target = client.target(STUDENT_SERVICES_URL + idToModify);
//
// Builder request = target.request();
// request.accept(MediaType.APPLICATION_XML_TYPE);
// Response response = request.put(Entity.xml(studentToChange));
//
// responseCode = response.getStatus();
// logger.info("The response code from Put operation is: " + responseCode);
//
// if (responseCode == 200) {
// Student changedStudent = response.readEntity(Student.class);
// logger.debug("Student changed in PUT request: " + changedStudent);
// }
// }

// /* Using a Delete Http Command, we'll delete an existing student */
// public static void testDelete() {
// int idOfStudentToDelete = 100; /* just some hardcoded test data */
// int responseCode;
// Client client = getClient();
//
// WebTarget target = client.target(STUDENT_SERVICES_URL + idOfStudentToDelete);
//
// Builder request = target.request();
// request.accept(MediaType.APPLICATION_XML_TYPE);
// Response response = request.delete();
//
// responseCode = response.getStatus();
// logger.info("The response code from delete operation is: " + responseCode);
//
// if (responseCode == Status.OK.getStatusCode()) {
// logger.debug("Student removed");
// }
// }
//
 
//
//
// }
//
