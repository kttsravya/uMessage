package org.messenger.springproject.dao.jdbc;


import org.messenger.springproject.dao.ProfileDaoInterface;
import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("profileDao")
public class ProfileDaoImplementation implements ProfileDaoInterface {
	@Autowired
	@Qualifier("dataSource1")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ProfileRowMapper profileMapper;

	@PostConstruct
	public void setUp() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ProfileDaoImplementation() {
		//jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ArrayList<Profile> getAllProfiles() {
		String sql = "select * from profiles";
		ArrayList<Profile> profile = (ArrayList<Profile>) jdbcTemplate.query(sql, profileMapper);
		return profile;

	}

	public Profile getProfile(String profileName)  {
		String sql = "select * from profiles where profileName=?";
		Profile profile = jdbcTemplate.queryForObject(sql, profileMapper, profileName);
		return profile;
	}

	public void addProfile(Profile profile) throws ProfileAlreadyExistInDbException {
		long profileId = profile.getId();
		String profileName = profile.getProfileName();
		String firstName = profile.getFirstName();
		String lastName = profile.getLastName();
		Date created = profile.getCreated();
		
		  ArrayList<Profile> prolist = getAllProfiles();
		  for(Profile p: prolist){
			  if((p.getProfileName()).equals(profileName)){
				  throw new ProfileAlreadyExistInDbException("profile already exist in data base");
			  }
		  }
		 
		String sql = "INSERT INTO profiles(id,profileName,firstName,lastName,created) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, profileId, profileName, firstName, lastName, created);

	}

	public void updateProfile(Profile profile) {
		String profileName1 = profile.getProfileName();
		String sql1 = "DELETE from profiles where profileName=?";
		jdbcTemplate.update(sql1, profileName1);

		long profileId = profile.getId();
		String profileName = profile.getProfileName();
		String firstName = profile.getFirstName();
		String lastName = profile.getLastName();
		Date created = profile.getCreated();
		String sql = "INSERT INTO profiles(id,profileName,firstName,lastName,created) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, profileId, profileName, firstName, lastName, created);

	}

	public void removeProfile(String profileName) {

		String sql1 = "DELETE from profiles where profileName=?";
		jdbcTemplate.update(sql1, profileName);

	}

	
	public long getProfileIdWithProfileName(String profileName) {
		String sql1 = "select id from profiles where profileName=?";
		long id = jdbcTemplate.queryForObject(sql1, new Object[]{profileName},Long.class);
		return id;
		
	}
}
