package org.messenger.springproject.daoclient;

import java.util.ArrayList;


import org.messenger.springproject.domain.Message;
import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.services.MessageService;
import org.messenger.springproject.services.ProfileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoClient {

	public static void main(String[] args)  {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("db-context.xml");
		AbstractApplicationContext container = new ClassPathXmlApplicationContext("service.xml");
		 ProfileService proserv = (ProfileService) container.getBean("profileservice");
		
			 Profile pro =  proserv.getProfile("sravyasravs");
			 System.out.println(pro.getId() +" "+pro.getLastName() );
		
		 
		
		
		



	}
}
