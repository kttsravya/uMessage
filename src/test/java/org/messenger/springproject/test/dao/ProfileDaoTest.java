package org.messenger.springproject.test.dao;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.messenger.springproject.dao.jdbc.ProfileDaoImplementation;
import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// ***should test each test case individually

@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileDaoTest {
	@Autowired
	@Qualifier("profileDao")
	private ProfileDaoImplementation pro; 
	private Profile p;

	@Before
	public void init() {
           // this record already exist in database
		p = new Profile(1, "sravyasravs", "lakshmi", "katta");
		

	}
	
	

	@Test
	public void testGetProfile()  {
		String profileName = p.getProfileName();
		
		Profile retrievedpr = pro.getProfile(profileName);
		assertEquals(retrievedpr, p);
	}
	
	@Test
	public void testAddProfile() throws ProfileAlreadyExistInDbException {
		Profile profile1 = new Profile(99,"srisri","srikan","mun");
		pro.addProfile(profile1);
		Profile profile2 = pro.getProfile("srisri");
		assertEquals(profile1,profile2);
	}
	
	@Test
	public void testUpdateProfile(){
		Profile profile1 = pro.getProfile("srisri");
		profile1.setLastName("munna");
		pro.updateProfile(profile1);
		Profile profile2 = pro.getProfile("srisri");
		assertEquals(profile2.getLastName(),"munna");
	}
	
	@Test(expected=ProfileAlreadyExistInDbException.class)
	public void duplicateProfileEntryException() throws ProfileAlreadyExistInDbException{
		pro.addProfile(p);
	}
	
	@Test
	public void testRemoveProfile(){
		String profileName = "srisri";
	   ArrayList<Profile> prolist =pro.getAllProfiles();
	   int count = prolist.size();
	   pro.removeProfile(profileName);
	   ArrayList<Profile> prolist1 =pro.getAllProfiles();
	   int count1 = prolist1.size();
	   assertEquals(count-1, count1);
		
		
	}
}




	


