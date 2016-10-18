package org.messenger.springproject.dao.mock;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.messenger.springproject.dao.ProfileDaoInterface;
import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;
import org.springframework.stereotype.Component;

@Component("profileservicemock")
public class ProfileServiceMock implements ProfileDaoInterface {

	

	private ArrayList<Profile> proList;
	
	 public ProfileServiceMock() {
		 Profile p;
			proList = new ArrayList<Profile>();
			p = new Profile(1, "sravyasravs", "lakshmi", "katta");
			proList.add(p);
			p = new Profile(2, "vineelvinni", "vineel", "pullipudi");
			proList.add(p);
			p = new Profile(3, "divyadiva", "divya", "katta");
			proList.add(p);
	}

//	@PostConstruct
//	public void init() {
//		Profile p;
//		proList = new ArrayList<Profile>();
//		p = new Profile(1, "sravyasravs", "lakshmi", "katta");
//		proList.add(p);
//		p = new Profile(2, "vineelvinni", "vineel", "pullipudi");
//		proList.add(p);
//		p = new Profile(3, "divyadiva", "divya", "katta");
//		proList.add(p);
//	}

	@Override
	public ArrayList<Profile> getAllProfiles() {

		return proList;
	}

	@Override
	public Profile getProfile(String profileName) {
		for (Profile p : proList) {
			if ((p.getProfileName()).equals(profileName)) {
				return p;
			}
		}
		return null;

	}

	@Override
	public void addProfile(Profile profile) throws ProfileAlreadyExistInDbException {
		//throw new ProfileAlreadyExistInDbException("from mock");
		proList.add(profile);
		System.out.println("added");

	}

	@Override
	public void updateProfile(Profile profile) {
		String proName = profile.getProfileName();
		for (Profile p : proList) {
			if ((p.getProfileName()).equals(proName)) {
				proList.remove(p);
			}
		}
		proList.add(profile);

	}

	@Override
	public void removeProfile(String profileName) {
		String proName = profileName;
		for (Profile p : proList) {
			if ((p.getProfileName()).equals(proName)) {
				proList.remove(p);
			}
		}

	}

	@Override
	public long getProfileIdWithProfileName(String profileName) {
		for(Profile p:proList){
			if(p.getProfileName().equals(profileName)){
				return p.getId();
			}
		}
		return 0;
	}

}
