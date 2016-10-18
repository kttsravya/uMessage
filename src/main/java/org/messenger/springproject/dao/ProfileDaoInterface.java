package org.messenger.springproject.dao;

import java.util.ArrayList;

import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;

public interface ProfileDaoInterface {
	public ArrayList<Profile> getAllProfiles();

	public Profile getProfile(String profileName); 

	public void addProfile(Profile profile) throws ProfileAlreadyExistInDbException;

	public void updateProfile(Profile profile);

	public void removeProfile(String profileName);
	
	public long getProfileIdWithProfileName(String profileName);
}
