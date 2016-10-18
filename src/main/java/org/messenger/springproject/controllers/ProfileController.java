package org.messenger.springproject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.messenger.springproject.domain.Profile;
import org.messenger.springproject.exceptions.ProfileAlreadyExistInDbException;
import org.messenger.springproject.services.ProfileService;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//
//import edu.npu.courseapp.domain.Gender;
//import edu.npu.courseapp.domain.Student;
//import edu.npu.courseapp.services.StudentService;
//
///*
//To get to the home page, point your browser to: http://localhost:8080/springproject 
//or get the new profile data form presented directly by going to: http://localhost:8080/springproject/newProfileDataForm
//*/



@Controller
public class ProfileController {
	@Autowired
	ProfileService profileservice;
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	// present the profile Data Form
	//should create new ProfileDataForm.jsp
	@RequestMapping(value="/newProfileDataForm", method=RequestMethod.GET)
	public ModelAndView newProfileDataForm(){
		ModelAndView modelView;
		modelView = new ModelAndView("ProfileDataForm");
		modelView.addObject("profile",new Profile());
		return modelView;
	}
	
	//process the data the user has entered in the profile data form
	//should create newProfileSucess.jsp
	@RequestMapping(value="/processNewProfileForm", method =RequestMethod.POST)
	public ModelAndView processNewProfileForm(String id,String profileName,String firstName,String lastName) throws ProfileAlreadyExistInDbException{
		ModelAndView modelView;
		Profile profile = new Profile();
		profile.setId(Long.parseLong(id));
		profile.setProfileName(profileName);
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profileservice.addProfile(profile);
		modelView = new ModelAndView("newProfileSucess");
		modelView.addObject("profile",profile);
		
		return modelView;
		
	}
	
	
}





