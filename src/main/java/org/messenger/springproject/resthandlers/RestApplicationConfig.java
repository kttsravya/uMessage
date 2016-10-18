package org.messenger.springproject.resthandlers;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
//import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbException;
import org.messenger.springproject.exceptions.MessageAlreadyExistInDbExceptionMapper;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbExceptionMapper;

//import org.glassfish.jersey.jackson.JacksonFeature;
//import org.glassfish.jersey.linking.DeclarativeLinkingFeature;



/*   See web.xml file for Jersey configuration  */
/*   Need to register classes with @PATH annotations and other JAX-RS components */
@ApplicationPath("/")
public class RestApplicationConfig extends Application {
	private Set<Class<?>> restClassSet = new HashSet<Class<?>>();
	
	public RestApplicationConfig() {
		/* AuthorizationFilter is a servlet filter that could automatically perform authorization on all incoming requests */
		//restClassSet.add(AuthorizationFilter.class);
		restClassSet.add(JacksonFeature.class);
		restClassSet.add(ProfileRestHandler.class);
		restClassSet.add(MessageRestHandler.class);
		restClassSet.add(MessageAlreadyExistInDbExceptionMapper.class);
		restClassSet.add(ProfileAlreadyExistInDbExceptionMapper.class);
		
        //restClassSet.add(InvalidAcctExResolver.class);
		//restClassSet.add(UnknownResourceExResolver.class);
		//restClassSet.add(DeclarativeLinkingFeature.class);  // Needed for @InjectLinks and @InjectLink
		
		
		
//		import javax.ws.rs.client.Invocation;
//		import javax.ws.rs.client.Invocation.Builder;
		
	}
	
	public Set<Class<?>> getClasses() {
		return restClassSet;
	}
}

