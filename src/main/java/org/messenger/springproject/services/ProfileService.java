package org.messenger.springproject.services;

import java.util.ArrayList;

import org.messenger.springproject.dao.ProfileDaoInterface;
import org.messenger.springproject.dao.jdbc.ProfileDaoImplementation;
import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("profileservice")
public class ProfileService {
	@Autowired
	@Qualifier("profileDao")
	ProfileDaoInterface prodaoimpl;

	public ProfileService() {

	}

	public ArrayList<Profile> getAllProfiles() {

		ArrayList<Profile> allprofiles = prodaoimpl.getAllProfiles();
		return allprofiles;

	}

	public Profile getProfile(String profileName)  {
		return prodaoimpl.getProfile(profileName);

	}

	public void addProfile(Profile profile) throws ProfileAlreadyExistInDbException {
		prodaoimpl.addProfile(profile);

	}

	public void updateProfile(Profile profile) {
		prodaoimpl.updateProfile(profile);
	}

	public void removeProfile(String profileName) {
		prodaoimpl.removeProfile(profileName);
	}
	
	public long getProfileIdWithProfileName(String profileName){
		return prodaoimpl.getProfileIdWithProfileName(profileName);
		
	}
}
