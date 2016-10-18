package org.messenger.springproject.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.messenger.springproject.domain.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ProfileRowMapper implements RowMapper<Profile> {

	public Profile mapRow(ResultSet arg0, int arg1) throws SQLException {
		long id;
		String profileName;
		String firstName;
		String lastName;
		Date created;
		Profile profile;

		id = arg0.getLong("id");
		profileName = arg0.getString("profileName");
		firstName = arg0.getString("firstName");
		lastName = arg0.getString("lastName");

		profile = new Profile(id, profileName, firstName, lastName);

		// created = arg0.getDate("created");

		// profile.setCreated(created);

		return profile;
	}

}
